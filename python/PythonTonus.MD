
**Create a python Flask application with 4 Crud enpoints**


Steps: 

**Step 1**

pip install flask

**Step 3**

*Add code:*

```

from flask import Flask, request, jsonify

app = Flask(__name__)

# In-memory "database"
from itertools import count
_id_counter = count(1)
customers = {}  # {id: {"id": id, "name": ..., "email": ..., "age": ...}}


# -------- Helpers --------
def _get_customer_or_404(cid: int):
    cust = customers.get(cid)
    if not cust:
        return jsonify({"error": f"Customer {cid} not found"}), 404
    return cust


def _validate_payload(data, *, require_all_fields=False):
    """
    Very small validator. If require_all_fields is True,
    ensure name, email, and age are present.
    """
    allowed = {"name", "email", "age"}
    if not isinstance(data, dict):
        return {"error": "JSON object expected"}, 400

    if require_all_fields and not allowed.issubset(data.keys()):
        missing = sorted(list(allowed - set(data.keys())))
        return {"error": f"Missing required fields: {', '.join(missing)}"}, 400

    # Type checks (lightweight)
    if "name" in data and not isinstance(data["name"], str):
        return {"error": "name must be a string"}, 400
    if "email" in data and not isinstance(data["email"], str):
        return {"error": "email must be a string"}, 400
    if "age" in data and not isinstance(data["age"], int):
        return {"error": "age must be an integer"}, 400

    # Filter out unknown fields
    filtered = {k: v for k, v in data.items() if k in allowed}
    return filtered, 200


# -------- Routes --------
@app.get("/health")
def health():
    return {"status": "ok"}, 200


@app.get("/customers")
def list_customers():
    """
    List all customers.
    """
    return jsonify(list(customers.values())), 200


@app.post("/customers")
def create_customer():
    """
    Create a new customer.
    Body JSON: { "name": str, "email": str, "age": int }
    """
    payload = request.get_json(silent=True)
    validated, code = _validate_payload(payload, require_all_fields=True)
    if code != 200:
        return jsonify(validated), code

    cid = next(_id_counter)
    customer = {"id": cid, **validated}
    customers[cid] = customer
    return jsonify(customer), 201


@app.get("/customers/<int:cid>")
def get_customer(cid: int):
    """
    Read a single customer by id.
    """
    cust = _get_customer_or_404(cid)
    if isinstance(cust, tuple):  # error tuple
        return cust
    return jsonify(cust), 200


@app.put("/customers/<int:cid>")
def replace_customer(cid: int):
    """
    Replace a customer (all fields required).
    Body JSON: { "name": str, "email": str, "age": int }
    """
    if cid not in customers:
        return jsonify({"error": f"Customer {cid} not found"}), 404

    payload = request.get_json(silent=True)
    validated, code = _validate_payload(payload, require_all_fields=True)
    if code != 200:
        return jsonify(validated), code

    customers[cid].update(validated)
    customers[cid]["id"] = cid
    return jsonify(customers[cid]), 200


@app.patch("/customers/<int:cid>")
def update_customer(cid: int):
    """
    Partially update a customer (only provided fields updated).
    Body JSON may include any subset of: name, email, age.
    """
    if cid not in customers:
        return jsonify({"error": f"Customer {cid} not found"}), 404

    payload = request.get_json(silent=True)
    validated, code = _validate_payload(payload or {}, require_all_fields=False)
    if code != 200:
        return jsonify(validated), code

    customers[cid].update(validated)
    return jsonify(customers[cid]), 200


@app.delete("/customers/<int:cid>")
def delete_customer(cid: int):
    """
    Delete a customer.
    """
    if cid not in customers:
        return jsonify({"error": f"Customer {cid} not found"}), 404

    deleted = customers.pop(cid)
    return jsonify({"deleted": deleted}), 200


if __name__ == "__main__":
    # Run the Flask app
    app.run(host="0.0.0.0", port=5000, debug=True)


```


**Step 3**

*Use the apis for testings :*

```

# Create
curl -X POST http://localhost:5000/customers \
  -H "Content-Type: application/json" \
  -d '{"name":"Alice","email":"alice@example.com","age":30}'

# List
curl http://localhost:5000/customers

# Get one (id=1)
curl http://localhost:5000/customers/1

# Replace (PUT requires all fields)
curl -X PUT http://localhost:5000/customers/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"Alice B","email":"alice.b@example.com","age":31}'

# Partial update (PATCH)
curl -X PATCH http://localhost:5000/customers/1 \
  -H "Content-Type: application/json" \
  -d '{"age":32}'

# Delete
curl -X DELETE http://localhost:5000/customers/1


```
