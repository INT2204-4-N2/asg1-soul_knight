package dictionary;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class DictionaryManagement {
    ArrayList<Word> result = new ArrayList<>();
    ArrayList<Word> words = new ArrayList<>();

    public DictionaryManagement() {
        this.insertFromFile();
    }

    public void DictionarySelection() {
        Scanner sc = new Scanner(System.in);
        int Select = sc.nextInt();
        switch (Select) {
            case 1:
                //this.dictionaryLookup();
                break;
            case 2:
                this.setNewWord();
                break;
            case 3:
                this.dictionnaryExportToFile();
                break;
        }
    }

    public Word setNewWord() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap them tu: ");
        String word_target = sc.nextLine();
        System.out.println("nhap nghia: ");
        String word_explain = sc.nextLine();
        result.add(new Word(word_target, word_explain));

        return new Word(word_target.toLowerCase(), word_explain.toLowerCase());
    }

    public void insertFromFile() {
        String[] wordsAdd;

        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\Soul_knight\\src/E_V.txt"));
            String line = "";
            while ((line = br.readLine()) != null) {
                wordsAdd = line.split("<html>");
                if (wordsAdd.length >= 2) {
                    Word word = new Word(wordsAdd[0], wordsAdd[1]);
                    result.add(word);
                    words.add(word);
                }
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("cannot open file: E_V.txt");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void dictionnaryExportToFile() {
        File file = new File("xuat du lieu tu dien.txt");
        try (PrintWriter pw = new PrintWriter(file)) {
            for (int i = 0; i < result.size(); i++) {
                pw.print(result.get(i).getWord_target() + "\t" + result.get(i).getWord_explain() + "\r\n");
            }

        } catch (Exception e) {
        }
    }

    private int binarySearcher(int start, int end, String spelling) {
        if (end < start) return -1;
        int mid = start + (end - start) / 2;
        Word word = words.get(mid);
        String currentSpelling = word.getSpelling();
        if (currentSpelling.startsWith(spelling)) {
            return mid;
        }
        int compare = currentSpelling.compareTo(spelling);
        if (compare == 0) return mid;
        if (compare > 0) return binarySearcher(start, mid - 1, spelling);
        return binarySearcher(mid + 1, end, spelling);
    }


    public ArrayList<Word> insertFromcomandline() {
        DictionaryManagement b = new DictionaryManagement();
        ArrayList<Word> a = new ArrayList<>();
        Dictionary s = new Dictionary();
        int k;
        k = b.nhapso();
        for (int i = 0; i < k; i++) {
            a.add(i, b.AddWord());
        }
        return a;
    }

    public Word AddWord() {
        Word array = new Word();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập từ tiếng Anh : ");
        String a;
        a = sc.nextLine();
        array.setWord_target(a);
        System.out.println("Nghĩa tiếng Việt : ");
        String b;
        b = sc.nextLine();
        array.setWord_explain(b);
        return array;
    }

    public int nhapso() {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập số lượng từ vựng");
        n = sc.nextInt();
        return n;
    }

    public ArrayList<Word> ReWrite(Dictionary S) {

        result = S.words;
        System.out.print("nhap tu muon sua");
        Scanner sc = new Scanner(System.in);

        String b = sc.nextLine();
        int dem = 0;

        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).getWord_target().contains(b) || result.get(i).getWord_explain().contains(b)) {
                System.out.println("Nhap tu moi chinh sua");
                Scanner c = new Scanner(System.in);
                result.get(i).setWord_explain(c.nextLine());
                Scanner d = new Scanner(System.in);
                result.get(i).setWord_target(d.nextLine());

                dem = dem + 1;
            }


        }
        if (dem == 0) System.out.println("tu can xoa ko dc tim thay");
        return result;

    }

    public String dictionaryLookup(String value) {

        String a = "";
        for (int i = 0; i < result.size(); i++) {
            if (value.equals(result.get(i).getWord_target())) {

                a = result.get(i).getWord_explain();
            }
        }
        return a;
    }
    public ArrayList<Word> Delete(Dictionary S){
        ArrayList<Word> a=new ArrayList<Word> ();
        a =  S.words;
        System.out.print ("nhap tu muon xoa");
        Scanner sc = new Scanner(System.in);
        int dem=0;
        String  b=sc.nextLine();
        for (int i = 0; i < a.size (); i++) {
            if(a.get(i).getWord_target().contains(b)||a.get(i).getWord_explain ().contains(b)){
                a.remove (i);
                dem=dem+1;
            }



        }
        if(dem==0) System.out.println ("tu can xoa ko dc tim thay");
        return  a;

    }
    public ArrayList<Word> EditWord(Dictionary S){
        ArrayList<Word> a=new ArrayList<Word> ();
        a =  S.words;
        System.out.print ("nhap tu muon sua");
        Scanner sc = new Scanner(System.in);

        String  b=sc.nextLine();
        int dem=0;

        for (int i = 0; i < a.size (); i++) {
            if(a.get(i).getWord_target().contains(b)||a.get(i).getWord_explain ().contains(b)){
                System.out.println ("Nhap tu moi chinh sua");
                Scanner c=new Scanner (System.in);
                a.get (i).setWord_explain (c.nextLine ());
                Scanner d=new Scanner (System.in);
                a.get (i).setWord_target (d.nextLine ());

                dem=dem+1;
            }



        }
        if(dem==0) System.out.println ("tu can xoa ko dc tim thay");
        return  a;

    }
}
