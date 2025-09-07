Steps: 

**Step 1**

ng new notes-app

*(CSS, serverside rendering - N)*

**Step 2**

*For drag & drop reordering, we’ll use Angular CDK:*

npm install @angular/cdk

**Step 3**

ng generate component features/notes

cd notes-app

**Step 4**

ng serve -o

**Step 5**

*For drag & drop reordering, we’ll use Angular CDK:*

npm install @angular/cdk@^19 @angular/material@^19

ng add @angular/material@19

**Step 6**

ng generate component features/notes

**Step 7**

ng g s services/notes

**Step 8**

*Add to src/app/features/notes/notes.component.ts*

```

import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatTabsModule } from '@angular/material/tabs';
import { DragDropModule, CdkDragDrop, moveItemInArray } from '@angular/cdk/drag-drop';
import { NotesService, Note } from '../../services/notes.service';

@Component({
  selector: 'app-notes',
  standalone: true,
  imports: [CommonModule, FormsModule, MatTabsModule, DragDropModule],
  templateUrl: './notes.component.html',
  styleUrls: ['./notes.component.css']
})
export class NotesComponent {
  topics: string[] = [];
  selectedTopic = '';
  newTopicName = '';
  newNote = '';
  editingId: number | null = null;
  editText = '';

  constructor(private store: NotesService) {
    this.topics = this.store.getTopics();
    this.selectedTopic = this.topics[0] ?? '';
  }

  get notes(): Note[] {
    return this.selectedTopic ? this.store.getNotes(this.selectedTopic) : [];
  }

  onTabChange(idx: number) {
    this.selectedTopic = this.topics[idx] ?? '';
    this.editingId = null;
    this.editText = '';
  }

  addTopic() {
    const name = this.newTopicName.trim();
    if (!name) return;
    this.store.addTopic(name);
    this.topics = this.store.getTopics();
    const i = this.topics.indexOf(name);
    if (i >= 0) this.selectedTopic = this.topics[i];
    this.newTopicName = '';
  }

  removeCurrentTopic() {
    if (!this.selectedTopic) return;
    const cur = this.selectedTopic;
    this.store.removeTopic(cur);
    this.topics = this.store.getTopics();
    this.selectedTopic = this.topics[0] ?? '';
  }

  addNote() {
    const text = this.newNote.trim();
    if (text && this.selectedTopic) {
      this.store.addNote(this.selectedTopic, text);
      this.newNote = '';
    }
  }

  removeNote(id: number) {
    if (!this.selectedTopic) return;
    this.store.removeNote(this.selectedTopic, id);
    if (this.editingId === id) {
      this.editingId = null;
      this.editText = '';
    }
  }

  drop(event: CdkDragDrop<Note[]>) {
    if (!this.selectedTopic) return;
    const list = this.notes;
    moveItemInArray(list, event.previousIndex, event.currentIndex);
    this.store.reorderNotes(this.selectedTopic, list);
  }

  startEdit(n: Note) {
    this.editingId = n.id;
    this.editText = n.text;
  }

  saveEdit(n: Note) {
    const text = this.editText.trim();
    if (!text) return;
    n.text = text;
    this.store.reorderNotes(this.selectedTopic, this.notes); // persists
    this.editingId = null;
    this.editText = '';
  }

  cancelEdit() {
    this.editingId = null;
    this.editText = '';
  }
}

```



**Step 9**