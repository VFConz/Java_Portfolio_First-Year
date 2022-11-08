package part01;

public enum Department
{
ELECTRICAL(0),PHOTOGRAPHIC(1),COMPUTING(2),BOOKS(3),MUSIC(4),FASHION(5),OTHER(6);

    private final int i;
    Department(int i) { this.i = i;}

    private final String[] titles =
    {
            "Electrical",
            "Photographic",
            "Computing",
            "Books",
            "Music",
            "Fashion",
            "Other"
    };


    public String toString()
    {
        return titles[i];
    }
}
