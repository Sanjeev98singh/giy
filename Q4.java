package assignment4;

import jdk.internal.util.xml.impl.Input;


    private void UpdateMap(){
        try {
            FileReader fileReader = new FileReader(SourceFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line=bufferedReader.readLine();
            while (line!=null){
                    ArrayList<String> val = words.getOrDefault(line.length(),new ArrayList<String>());
                    val.add(line);
                    words.put(line.length(),val);
                line= bufferedReader.readLine();
            }

            bufferedReader.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void outputWordFrequency(String path){

        try {
            for (Map.Entry<Integer,ArrayList<String>> entry :
                words.entrySet()) {
                System.out.println( entry.getKey() + " length words are "+ entry.getValue().size());
                FileWriter fileWriter = new FileWriter(path+"/words"+entry.getKey()+".txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                for (String word:
                        entry.getValue()) {
                    bufferedWriter.write(word);
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
                fileWriter.close();
            }
          

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


public class Q4 {
    public static void main(String[] args) {
        scanText sc = new scanText("src/assignment4/words.txt");
        sc.outputWordFrequency("src/assignment4");
    }
}
