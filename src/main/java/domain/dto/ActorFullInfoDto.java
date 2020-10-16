package domain.dto;

public class ActorFullInfoDto {

    private String name;
    private String secondName;
    private String name2;
    private String director;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ActorFullInfoDto{");
        sb.append("name='").append(name).append('\'');
        sb.append(", secondName='").append(secondName).append('\'');
        sb.append(", name2='").append(name2).append('\'');
        sb.append(", director='").append(director).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
