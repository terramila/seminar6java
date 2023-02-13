    package sem6hom;
    
    import java.io.*;
    import java.lang.Object;
    import java.util.*;
    
    public class task1 {
        public static void main(String[] args) {
            
            NoteBook notebook1 = new NoteBook("Asus B1400CEAE-EB6196",16,1,"Windows","grey",50000);
            NoteBook notebook2 = new NoteBook("Lenovo V15G3IAP",8,1,"Windows","black",45000);
            NoteBook notebook3 = new NoteBook("Acer Aspire 3A315-5855MM",16,2,"Linux","white",78000);
            NoteBook notebook4 = new NoteBook("MacBook Air MGN63",8,4,"MacOs","grey",88000);
            NoteBook notebook5 = new NoteBook("Asus 4657839849",16,4,"Windows","black",64000);
        
            ArrayList<Integer> pricesList = new ArrayList<>();
            pricesList.add(notebook1.price);
            pricesList.add(notebook2.price);
            pricesList.add(notebook3.price);
            pricesList.add(notebook4.price);
            pricesList.add(notebook5.price);

            ArrayList<Integer> ramList = new ArrayList<>();
            ramList.add(notebook1.ram);
            ramList.add(notebook2.ram);
            ramList.add(notebook3.ram);
            ramList.add(notebook4.ram);
            ramList.add(notebook5.ram);
            
            ArrayList<Integer> hddList = new ArrayList<>();
            hddList.add(notebook1.hdd);
            hddList.add(notebook2.hdd);
            hddList.add(notebook3.hdd);
            hddList.add(notebook4.hdd);
            hddList.add(notebook5.hdd);
            
            try(FileOutputStream note=new FileOutputStream("notebook.txt");
                PrintStream printStream = new PrintStream(note))
            {
            printStream.println(notebook1);
            printStream.println(notebook2);
            printStream.println(notebook3);
            printStream.println(notebook4);
            printStream.println(notebook5);
            System.out.println("Список есть в файле.");
            }
            catch(IOException ex){
             
            System.out.println(ex.getMessage());
            }  
    
            System.out.println("Введите 1- наименование; 2- RAM по возрастанию; 3- HDD по возрастанию; 4- OS; 5- цвета; 6- цена по возрастанию.");
            Scanner scan = new Scanner(System.in);
            int parametr = scan.nextInt();
            scan.close();
            
        if(parametr == 1){ 
                System.out.println("1. "+notebook1.name);
                System.out.println("2. "+notebook2.name);
                System.out.println("3. "+notebook3.name);
                System.out.println("4. "+notebook4.name);
                System.out.println("5. "+notebook5.name);
        }
        else if(parametr == 2){
            ramList.sort(Comparator.naturalOrder());

            for(int i=0; i<ramList.size(); i++){
            System.out.print("\n"+(i+ 1)+". "+ramList.get(i)+"ГБ");
            }
        }   
        else if(parametr ==3){
            hddList.sort(Comparator.naturalOrder());
            
            for(int i=0; i<hddList.size(); i++){
            System.out.print("\n"+(i+ 1)+". "+hddList.get(i)+"ТБ");
            }
        }
        else if(parametr==4){
                System.out.println("1. "+notebook1.os);
                System.out.println("2. "+notebook2.os);
                System.out.println("3. "+notebook3.os);
                System.out.println("4. "+notebook4.os);
                System.out.println("5. "+notebook5.os);
        }
        else if(parametr==5){
                System.out.println("1. "+notebook1.colour);
                System.out.println("2. "+notebook2.colour);
                System.out.println("3. "+notebook3.colour);
                System.out.println("4. "+notebook4.colour);
                System.out.println("5. "+notebook5.colour);
        }
        else if(parametr ==6){
                pricesList.sort(Comparator.naturalOrder());
                
                for(int i=0; i<pricesList.size(); i++){
                System.out.print("\n"+(i+ 1)+". "+pricesList.get(i)+"руб.");
                }
        } 
        else{
            System.out.print("Ввод некорректный");
        }
        }
    }

    class NoteBook {  
        public Object toList;
        String name;    
        Integer ram;    
        Integer hdd;
        String os; 
        String colour; 
        Integer price;

        public NoteBook(String name, Integer ram, Integer hdd,
                String os, String colour,Integer price) 
            {  
                this.name = name;
                this.ram = ram;
                this.hdd = hdd;
                this.os = os;
                this.colour = colour;
                this.price = price;       
        }
    }

    