import java.io.File;

public class CoreFile {
    public File[] files;

    public CoreFile(String[] inputName) throws Exception{
        File[] files = new File[inputName.length];
        for (int i = 0; i < inputName.length; i++) {
            File f = new File(inputName[i]);
            if (!f.exists()) throw new Exception("This file not exist");
            else files[i] = f;
        }
        this.files = files;
    }

    public String[] core(Boolean h, Boolean c, Boolean si){
        double[] byteSize = getByteSizes(c);
        int base = base(si);

        String[] answer = new String[byteSize.length];

        for (int i = 0; i < byteSize.length; i++) {
            if (h != null){
                double s = byteSize[i];
                Unit u = new Unit(s, base);
                answer[i] = (u.l.toString()) + " " + u.unit;
            } else {
                Double s = byteSize[i] / base;
                answer[i] = s.toString();
            }
            if (i != byteSize.length - 1) answer[i] = answer[i] + ", ";
        }

        return answer;
    }

    private double[] getByteSizes(Boolean c) {
        double[] byteSize = new double[1];
        if (c != null) {
            byteSize[0] = 0.0;
            for (File f: files)
                byteSize[0] += getLength(f);
        }
        else for (int i = 0; i < files.length; i++)
            byteSize[i] = getLength(files[i]);
        return byteSize;
    }

    private int base(Boolean si){
        if (si != null) return 1000;
        else return 1024;
    }

    public double getLength(File f) {
        if (!f.isDirectory()) return f.length();
        else{
            double l = 0.0;
            for (String f1 : f.list()) l += getLength(new File(f.getPath() + File.separator + f1));
            return l;
        }
    }


}
