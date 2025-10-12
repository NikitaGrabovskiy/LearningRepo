package Examples;

public class Example43_OpenClosedBrackets {


    public static void main(String ... args){
        System.out.println(numberOfOperations("}{{}}{{{"));
    }


/*

    Examples
    {}{}{}
    {}}{{
    }{{}{}
    }}}}{{{}}{

    */
    private static int numberOfOperations(String brackets){

        if(brackets.length()%2!=0){
            return -1;
        }

        // try deleting them by replacing with third object

        char[] charArray = brackets.toCharArray();
        for(char loop:charArray){
            int openIndex = -1;
            for(int x = 0; x < charArray.length; x++){
                char currentChar = charArray[x];

                if(currentChar == '{' && openIndex ==-1){
                    openIndex = x;
                } else if(currentChar == '}' && openIndex !=-1){
                    charArray[x] = '#';
                    charArray[openIndex] = '#';
                    openIndex=-1;
                    System.out.println("Current chars " +String.valueOf(charArray));
                }
            }
        }
        int closedCount = 0;
        int openCount = 0;
        for(int x = 0; x < charArray.length; x++){
            char currentChar = charArray[x];
            if(currentChar == '{'){
                openCount++;
            } else if(currentChar == '}'){
                closedCount++;
            }
        }

        int max = Math.max(closedCount,openCount);
        int min = Math.min(closedCount,openCount);
        int reminder = max - min;
        return min*2+reminder;
    }


}
