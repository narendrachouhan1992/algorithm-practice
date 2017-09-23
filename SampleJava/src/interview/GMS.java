package interview;

public class GMS {
	static int closingBracePosition(String inputSentence, int openingBraceNum) {
        int size = inputSentence.length();
        int[] arr = new int[size];
        int pos = -1;
        int OpeningParanthasysNumber =0;
        int x=0;
        int closingParanthasysNumber = 0;
        for(int i=0;i<size;i++)
        {
            if(inputSentence.charAt(i)== '(' || inputSentence.charAt(i)== '{' || inputSentence.charAt(i) == '[')
            {
                arr[++pos] = inputSentence.charAt(i);
                if(OpeningParanthasysNumber!= openingBraceNum)
                {
                    OpeningParanthasysNumber++;
                }
                else
                {
                    x++;
                }
            }
            else if(inputSentence.charAt(i)== ']' || inputSentence.charAt(i)== '}' || inputSentence.charAt(i) == ')')
            {
               if(OpeningParanthasysNumber== openingBraceNum && x==0)
                {
                   closingParanthasysNumber = i+1;
                   OpeningParanthasysNumber++;
                }
                else if(OpeningParanthasysNumber== openingBraceNum && x!=0)
                {
                    x--;
                }
                else
                {
                }
                
                if(pos == -1)
                {
                    return -1;
                }
                else if (arr[pos] == '[' && inputSentence.charAt(i) == ']')
                {
                    pos--;
                }
                else if (arr[pos] == '{' && inputSentence.charAt(i) == '}')
                {
                    pos--;
                }
                else if (arr[pos] == '(' && inputSentence.charAt(i) == ')')
                {
                    pos--;
                }
                else
                {
                    return -1;
                }
            }
            else
            {
            }
        }
        if(pos == -1)
        {
            return closingParanthasysNumber;
        }
        else
        {
            return -1;
        }    
    }
	public static void main(String[] args) {
		System.out.println(closingBracePosition("(I want) (to write a language parser, would (you) help me)" ));
	}
}
