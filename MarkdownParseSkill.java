import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseSkill {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = 0;
            int closeBracket = 0;
            int openParen = 0;
            int closeParen = 0;
            if(markdown.indexOf(")", currentIndex) != -1 && markdown.indexOf("[",currentIndex) != -1 && markdown.indexOf("]",currentIndex) != -1 && markdown.indexOf("(",currentIndex) != -1){
               
                openBracket = markdown.indexOf("[", currentIndex); 
                if (openBracket == -1){openBracket = currentIndex + 1;}

                closeBracket = markdown.indexOf("]", openBracket);
                if(closeBracket == -1){closeBracket = openBracket + 1;}

                openParen = markdown.indexOf("(", closeBracket);
                if (openParen == -1){openParen = closeBracket+1;}

                closeParen = markdown.indexOf(")", openParen);
                if (closeParen == -1){closeParen = markdown.indexOf(".", openParen) + 3;}
            }else {break;}

            if (markdown.indexOf("!", 0)+1 == openBracket){
                break; 
            }else{
                toReturn.add(markdown.substring(openParen + 1, closeParen));
            }
            currentIndex = closeParen + 1;       
        }
        return toReturn;
    }

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
