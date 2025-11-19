public class EnigmaGUI {

    int index1, index2, index3;
    String index4;
    public EnigmaGUI(int index1, int index2, int index3, String index4)
    {
        this.index1 = index1;
        this.index2 = index2;
        this.index3 = index3;
        this.index4 = index4;
    }
    public static void main(String[] args) {
        EnigmaFrame frame = new EnigmaFrame();
        frame.setVisible(true);
    }
}
