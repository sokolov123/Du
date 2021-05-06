public class Unit {
    Double l;
    String unit;

    public Unit(Double l, int base) {
        String[] units = {"B", "KB", "MB", "GB"};
        //                 0    1      2     3
        int i = 0;
        while ((l > base) && (i < units.length)) {
            l /= base;
            i++;
        }
        this.l = l;
        this.unit = units[i];
    }
}
