public class MainClass {
    public static void main(String[] args) {
        AVLTree avl = new AVLTree();
        avl.print();
        System.out.println("height = " + avl.height());
        System.out.println();

        AVLTree avlLeftLeft = new AVLTree();
        Student[] dataLeftLeft = new Student[8];
        dataLeftLeft[0] = new Student("Kyle", "Freshman", 9);
        dataLeftLeft[1] = new Student("Megan", "Senior", 7);
        dataLeftLeft[2] = new Student("Raymond", "Junior", 10);
        dataLeftLeft[3] = new Student("Ryan", "Junior", 4);
        dataLeftLeft[4] = new Student("Sarah", "Freshman", 8);
        dataLeftLeft[5] = new Student("Tara", "Sophomore", 14);
        dataLeftLeft[6] = new Student("Tristan", "Junior", 2);
        dataLeftLeft[7] = new Student("Tyler", "Senior", 6);
        avlLeftLeft.insert(dataLeftLeft);
        avlLeftLeft.print();
        System.out.println("height = " + avlLeftLeft.height());
        System.out.println();
        
        avlLeftLeft.insert(new Student("Zack", "Sophomore", 3));
        avlLeftLeft.print();
        System.out.println("height = " + avlLeftLeft.height());
        System.out.println();
        
        AVLTree avlRightRight = new AVLTree();
        Student[] dataRightRight = new Student[8];
        dataRightRight[0] = new Student("Carson", "Freshman", 8);
        dataRightRight[1] = new Student("Chloe", "Senior", 3);
        dataRightRight[2] = new Student("Chris", "Junior", 10);
        dataRightRight[3] = new Student("Cole", "Junior", 1);
        dataRightRight[4] = new Student("Evan", "Freshman", 9);
        dataRightRight[5] = new Student("Abraham", "Sophomore", 14);
        dataRightRight[6] = new Student("Jordan", "Junior", 13);
        dataRightRight[7] = new Student("Justin", "Senior", 18);
        avlRightRight.insert(dataRightRight);
        avlRightRight.print();
        System.out.println("height = " + avlRightRight.height());
        System.out.println();
        
        avlRightRight.insert(new Student("Karl", "Sophomore", 19));
        avlRightRight.print();
        System.out.println("height = " + avlRightRight.height());
        System.out.println();

        AVLTree avlLeftRight = new AVLTree();
        Student[] dataLeftRight = new Student[9];
        dataLeftRight[0] = new Student("Ryan", "Freshman", 9);
        dataLeftRight[1] = new Student("Kyle", "Senior", 3);
        dataLeftRight[2] = new Student("Luci", "Junior", 10);
        dataLeftRight[3] = new Student("Nathan", "Junior", 2);
        dataLeftRight[4] = new Student("Karkar", "Freshman", 6);
        dataLeftRight[5] = new Student("Rebecca", "Sophomore", 14);
        dataLeftRight[6] = new Student("Saad", "Junior", 1);
        dataLeftRight[7] = new Student("Souhaib", "Senior", 4);
        dataLeftRight[8] = new Student("Zain", "Senior", 7);
        avlLeftRight.insert(dataLeftRight);
        avlLeftRight.print();
        System.out.println("height = " + avlLeftRight.height());
        System.out.println();
        
        avlLeftRight.insert(new Student("Zach", "Sophomore", 8));
        avlLeftRight.print();
        System.out.println("height = " + avlLeftRight.height());
        System.out.println();
        
        AVLTree avlRightLeft = new AVLTree();
        Student[] dataRightLeft = new Student[9];
        dataRightLeft[0] = new Student("Aiden", "Freshman", 9);
        dataRightLeft[1] = new Student("Joseph", "Senior", 3);
        dataRightLeft[2] = new Student("Ebru", "Junior", 19);
        dataRightLeft[3] = new Student("Elena", "Junior", 5);
        dataRightLeft[4] = new Student("Eva", "Freshman", 14);
        dataRightLeft[5] = new Student("Jack", "Sophomore", 33);
        dataRightLeft[6] = new Student("Jacob", "Junior", 13);
        dataRightLeft[7] = new Student("JJ", "Senior", 17);
        dataRightLeft[8] = new Student("Cameron", "Senior", 37);
        avlRightLeft.insert(dataRightLeft);
        avlRightLeft.print();
        System.out.println("height = " + avlRightLeft.height());
        System.out.println();
        
        avlRightLeft.insert(new Student("Richard", "Sophomore", 11));
        avlRightLeft.print();
        System.out.println("height = " + avlRightLeft.height());
        System.out.println();
    }
}
