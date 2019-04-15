package ua.pr;

public class Lab3PR_User {
    private int id;
    private String name;
    private String email;

    public Lab3PR_User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public void setId(int newId){
        this.id=newId;
    }

    public void setName(String newName){
        this.name=newName;
    }

    public void setEmail(String newEmail){
        this.email=newEmail;
    }

    @Override
    public String toString(){
        return getId()+' '+getName()+' '+getEmail();
    }
}
