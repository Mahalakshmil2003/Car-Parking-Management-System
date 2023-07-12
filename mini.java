import java.util.*;
//Class to Store and print car details
class CarParkManager{
private String vehicle;
private String model;
private String colour;
private String regPlate;
private int slot;
	
//To store Each car details
public CarParkManager(String vehicle,String model,String colour,String regPlate,int slot){
this.vehicle=vehicle;
this.model=model;
this.colour=colour;
this.regPlate=regPlate;
this.slot=slot;
}
//to get regPlate value
public String regPlate(){
String plate=this.regPlate;
return plate;
}
//To print all the car details
public void printParkedVehicleDetails(){
System.out.println("\n"+vehicle+"\t\t"+model+"\t\t"+colour+"\t\t"+regPlate+"\t\t\t"+slot);
}
}

//Main class
public class mini{
public static void main(String[] args) {
mini m= new mini();	
int MAX=5;
CarParkManager myCarPark[]= new CarParkManager[MAX+1];
Scanner input = new Scanner(System.in);
int j,free=0,avail=0,count=0,menu=0;
int flag[]=new int[MAX+1];
for(int i=1;i<=MAX;i++) flag[i]=0;
String vehicle;
do {
m.dispMenu();
System.out.print("Enter your choice: ");
try{
menu=input.nextInt();
}catch(Exception e){System.out.println("Invalid Choise");}
switch (menu) {
case 1: {
for(int i=1;i<=MAX;i++){
if(flag[i]==0){
free=i;
break;
  }
}
if(count==MAX){
System.out.println("Parking is full");break;
}
else
 {
 String vType;
 System.out.println("Please choose The Vehicle type");
 System.out.println("C = CAR");
 System.out.println("B = BIKE");
 System.out.println("V = VAN");
  vType = input.next();
  if (vType.equals("C")||vType.equals("c")) {
  vehicle="CAR";
  System.out.println("Enter Model");
  String model = input.next();
  System.out.println("Enter Colour");
  String colour = input.next();
  System.out.println("Enter Reg Plate");
  String regPlate = input.next();
 myCarPark[free]=new CarParkManager(vehicle,model,colour,regPlate,free);
 flag[free]=1;
 count++;
} 
else if (vType.equals("B")||vType.equals("b")) {
vehicle="BIKE";
System.out.println("Enter Model");
String model = input.next();
System.out.println("Enter Colour");
String colour = input.next();

System.out.println("Enter Reg Plate");
String regPlate = input.next();
myCarPark[free]=new CarParkManager(vehicle,model,colour,regPlate,free);
flag[free]=1;
count++;
} 
else if (vType.equals("V")||vType.equals("v")) {
vehicle="VAN";
System.out.println("Enter Model");
String model = input.next();

System.out.println("Enter Colour");
String colour = input.next();

System.out.println("Enter Reg Plate");
String regPlate = input.next();

myCarPark[free]=new CarParkManager(vehicle,model,colour,regPlate,free);
flag[free]=1;
count++;
}
break;
}
}
case 2: {
int found=0;
if(count==0) {
System.out.println("No cars are Parked");
}
System.out.println("Enter Slot alloted to the Car:");
int slotNo=input.nextInt();	
if(flag[slotNo]==0) 
System.out.println("Car not Found");
else 
flag[slotNo]=0;
count - -;
break;
}
case 3: {
if(count==0) System.out.println("No cars are Parked");
else{
System.out.println("List of All Parked Vehicles : ");
System.out.println("\nVehicle\t\tModel\t\tColour\t\tRegPlate No.\t\tSlot Allotted");
for(j=1;j<=MAX;j++){
if(flag[j]==1)
myCarPark[j].printParkedVehicleDetails();
}
break;}
}
case 4: {
String[] Plate=new String[MAX+1];
int k=1;
for(j=1;j<=MAX;j++){
if(flag[j]==1)
Plate[k]=myCarPark[j].regPlate();k++;
}
int found=0;
System.out.println("Enter car munber");
String carno=input.next();
for(j=1;j<k;j++){
if(carno.equals(Plate[j])){
found=j;
System.out.println("Car is in slot:"+j);
}
}
if(found==0)
System.out.println("Car not Found");
break;
}
case 0: {
System.out.println("\nThank you!\n");
break;
}
default: {
System.out.println("Invalid option!\n");
break;
}
}
} while (menu != 0);
}
public void dispMenu(){
System.out.println("WELCOME TO PARKING MANAGEMENT");
System.out.println("1: To Park Vehicle");
System.out.println("2: To Departure");
System.out.println("3: Show All Parked Vehicles");
System.out.println("4: Find Vehicle");
System.out.println("0: To Exit");
}
}
