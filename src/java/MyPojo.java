/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author golpik
 */
public class MyPojo
{
    private String name;

    private String age;

    private String blog;

    private String[] messages;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getAge ()
    {
        return age;
    }

    public void setAge (String age)
    {
        this.age = age;
    }

    public String getBlog ()
    {
        return blog;
    }

    public void setBlog (String blog)
    {
        this.blog = blog;
    }

    public String[] getMessages ()
    {
        return messages;
    }

    public void setMessages (String[] messages)
    {
        this.messages = messages;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+", age = "+age+", blog = "+blog+", messages = "+messages+"]";
    }
}