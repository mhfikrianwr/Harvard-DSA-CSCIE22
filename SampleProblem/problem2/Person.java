package problem2;
public class Person {
    // task 1 -> create the field
    private String name;
    private Date birth;
    
    // task 2 ->  create the constructor
    public Person(String name, Date birth){
        this.name = name;
        this.birth = birth;
    }

    // task 3-> create the accesors method 

    public String getName(){
        return this.name;
    }

    public Date getDOB(){
        return this.birth;
    }

    public Date getBirthdayIn(int year){
        return new Date(this.birth.getMonth(),this.birth.getDate(), year);
    }

    public int getAgeOn(Date now){
        int age = now.getYear() - this.birth.getYear();
        if(now.isBefore(this.getBirthdayIn(now.getYear()))) age--;
        return age;
    }

    public String toString(){
        return this.name + " (born on" + this.birth + ")\n"; 
    }

    //task 4 ->  birthdayCalculator program
    
}
