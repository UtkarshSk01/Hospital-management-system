public class Doctor {
    private int id;
    private String name;
    private String specialization;

    public Doctor() {}

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
