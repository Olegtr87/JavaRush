package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу

        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("d:/1.txt");
            InputStream inputStream = new FileInputStream("d:/1.txt");
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1=new User();
            user1.setFirstName("oleg");
            user1.setLastName("vasil");
            user1.setBirthDate(dateFormat.parse("14.03.1995"));
            user1.setMale(true);
            user1.setCountry(User.Country.UKRAINE);

            User user2=new User();
            user2.setFirstName("vasya");
            user2.setLastName("ivanov");
            user2.setBirthDate(dateFormat.parse("14.03.1976"));
            user2.setMale(false);
            user2.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user1);
            javaRush.users.add(user2);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(javaRush.equals(loadedObject));
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        public void save(OutputStream outputStream) throws Exception {

            PrintWriter writer=new PrintWriter(outputStream);
            String hasUser=(this.users.isEmpty()!=true)?"yes":"no";
            writer.println(hasUser);
            if (hasUser.equals("yes")){

                for (User current : this.users){
                    if (current.getFirstName().isEmpty()!=true){
                        writer.println("yes");
                        writer.println(current.getFirstName());} else {writer.println("no");writer.println("noFirstName");}
                    if (current.getLastName().isEmpty()!=true){
                        writer.println("yes");
                        writer.println(current.getLastName());} else {writer.println("no");writer.println("noLastName");}

                    if (current.getBirthDate().toString().isEmpty()!=true){
                        writer.println("yes");
                        writer.println(dateFormat.format(current.getBirthDate()));} else {writer.println("no");writer.println("noBirthDate");}

                    if (current.getCountry().toString().isEmpty()!=true){
                        writer.println("yes");
                        writer.println(current.getCountry());} else {writer.println("no");writer.println("noCountry");}
                    if (current.isMale()==true){
                        writer.println("yes");
                        writer.println(current.isMale());} else {writer.println("no");writer.println(current.isMale());}
                    }
            }
            writer.close();

            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {

            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));



            String usery=reader.readLine();
            if (usery.equals("yes")){
                while (reader.ready()){



                    User user = new User();
                    usery=reader.readLine();
                    if (usery.equals("yes")) {usery=reader.readLine();user.setFirstName(usery);} else {usery=reader.readLine();user.setFirstName(null);}
                    usery=reader.readLine();
                    if (usery.equals("yes")) {usery=reader.readLine();user.setLastName(usery);} else {usery=reader.readLine();user.setLastName(null);}
                    usery=reader.readLine();
                    if (usery.equals("yes")) user.setBirthDate(dateFormat.parse(reader.readLine())); else {usery=reader.readLine();user.setBirthDate(null);}
                    usery=reader.readLine();
                    if (usery.equals("yes")) user.setCountry(User.Country.valueOf(reader.readLine())); else  {usery=reader.readLine();user.setCountry(null);}
                    usery=reader.readLine();
                    if (usery.equals("yes")) {usery=reader.readLine();user.setMale(true);}else  {usery=reader.readLine(); user.setMale(false);}

                    users.add(user);

                }
            }
            reader.close();
        }
    }
}
