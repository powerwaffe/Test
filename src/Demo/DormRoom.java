package Demo;

/**
 * Created by Sean on 10/20/2015.
 */
class DormRoom {
    String dormName;
    int roomNumber;

    DormRoom(String arg1, int arg2) {
        dormName = arg1;
        roomNumber = arg2;
    }
}

class Student {
    String firstName;
    String lastName;
    int studentID;
    DormRoom dormRoom;

    Student(int arg1, String arg2, String arg3) {
        studentID=arg1;
        firstName=arg2;
        lastName=arg3;
    }
}
