package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
    public static void main(String[] args) {
        /* 일반적인 객체 생성 */
        User user = new User("marco", 30);
        System.out.println(user.toString());

        /* reflection을 사용한 개체 생성. */
        try{
            Class userClass = Class.forName(User.class.getName()); // 물리적인 클래스 파일명을 인자로 넘겨주면 이에 해당하는 클래스 반환.
            Constructor<?> constructor = userClass.getConstructor(); // public 접근자를 가진 생성자를 반환.
            User user2 = (User) constructor.newInstance();
            System.out.println(user2);
        }catch(ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }catch(InvocationTargetException e) {
            e.printStackTrace();
        }catch(InstantiationException e) {
            e.printStackTrace();
        }catch(IllegalAccessException e) {
            e.printStackTrace();
        }

        /* Argunents 전달되는 객체를 생성하는 예제 */
        try{
            Constructor cUser =
                    Class.forName(User.class.getName()).getConstructor(String.class, Integer.TYPE);
            User user3 = (User) cUser.newInstance("marco", 20);
            System.out.println(user3);
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }catch(InvocationTargetException e) {
            e.printStackTrace();
        }catch(NoSuchMethodException e){
            e.printStackTrace();
        }catch(InstantiationException e){
            e.printStackTrace();
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }

        System.out.print(System.lineSeparator());

        /* 일반적인 메소드 호출 */
        System.out.println(user.getUserName());
        System.out.println(user.getUserAge());

        System.out.println(System.lineSeparator());

        /* reflection API를 이용한 메소드 호출 */
        try {
            Class clazz = Class.forName(User.class.getName());
            Object user4 = clazz.getDeclaredConstructor().newInstance();
            Method setUserNameMethod =clazz.getDeclaredMethod("setUserName",String.class);
            setUserNameMethod.invoke(user4, "NHN 아카데미");
            Method getUserNameMethod =clazz.getDeclaredMethod("getUserName");
            String userName = (String)
                    getUserNameMethod.invoke(user4);
            Method setUserAgeMethod =clazz.getDeclaredMethod("setUserAge",Integer.TYPE);
            setUserAgeMethod.invoke(user4, 30);
            Method getUserAgeMethod =clazz.getDeclaredMethod("getUserAge");
            int userAge = (int) getUserAgeMethod.invoke(user4);
            System.out.println("userName:" + userName);
            System.out.println("userAge:" + userAge);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.print(System.lineSeparator());

        /* reflection API를 이용한 필드 접근 */
        try{
            Class clazz = Class.forName(User.class.getName());
            Object user5 = clazz.getDeclaredConstructor().newInstance();
            Field userNameField = clazz.getDeclaredField("userName");
            userNameField.setAccessible(true);
            userNameField.set(user5, "marco");
            String userName = (String) userNameField.get(user5);
            Field userAgeField = clazz.getDeclaredField("userAge");
            userAgeField.setAccessible(true);
            userAgeField.set(user5, 30);
            int userAge = userAgeField.getInt(user5);
            System.out.println("userName:" + userName);
            System.out.println("userAge:" + userAge);
        }catch(NoSuchFieldException e) {
            e.printStackTrace();
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }catch(InvocationTargetException e) {
            e.printStackTrace();
        }catch(InstantiationException e) {
            e.printStackTrace();
        }catch(IllegalAccessException e) {
            e.printStackTrace();
        }catch(NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
