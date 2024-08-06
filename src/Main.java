import java.awt.desktop.OpenURIEvent;
import java.util.*;

public class Main {

    static List<Student> studentList = new ArrayList<>();
    public static void main(String[] args)
    {


        int n ;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao so luong sv:");
        n = scanner.nextInt();

        for(int i = 1;i<=n;i++){
            input();
        }
        System.out.println("IN DANH SACH SV:");
        output();


        scanner.nextLine();

        String codeInput;
        System.out.println("Nhap ma sinh vien can xoa:");
        codeInput = scanner.nextLine();
        removeByCode(codeInput);

        output();

        System.out.println("SAP XEP THEO DIEM GIAM DAN:");
        sortByGradeDesc();
        output();


    }

    // Nhap moi 1 sinh vien
    public static void input()
    {


        System.out.println("Nhap vao thong tin sinh vien:");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap ma sv:");
        String code = scanner.nextLine();
        System.out.println("Nhap ten sv:");
        String name = scanner.nextLine();
        System.out.println("Nhap diem:");
        float grade = scanner.nextFloat();
        Student student = new Student(code, name, grade);
        studentList.add(student);






    }

    // In danh sach sinh vien
    public static void output(){

        for(Student student: studentList){

            System.out.println(student.toString());
        }

    }

    public static void removeByCode(String code)
    {
        // foreach duyet phan tu trong LIST
        try{
            for(Student student: studentList){
                if(student.getCode().equals(code)){
                    studentList.remove(student);
                }
            }
        }catch (Exception ex){

        }

    }

    public static  void sortByGradeDesc(){
        // Su dung Collection de sap xep

        Collections.sort(studentList, Comparator.comparing(Student::getGrade).reversed());
    }

    public static List<Student> findByCodeOrName(String keyword){
        List<Student> stds = new ArrayList<>();

        for(Student student: studentList){
            // || = OR Hoac
            if(student.getCode().equals(keyword) || student.getName().equals(keyword)){
                stds.add(student);
            }
        }
        return stds;
    }

    public static List<Student> filterByGrade(float x){

        List<Student> list = new ArrayList<>();

        for(Student student: studentList){

            if(student.getGrade()>= x){
                list.add(student);
            }
        }

        return  list;
    }
}