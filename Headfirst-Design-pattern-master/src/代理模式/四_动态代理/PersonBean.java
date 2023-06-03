package 代理模式.四_动态代理;

public interface PersonBean {
 
	String getName();//姓名
	String getGender();//性别
	String getInterests();//兴趣
	int getHotOrNotRating();//是否受欢迎的评分
 
    void setName(String name);
    void setGender(String gender);
    void setInterests(String interests);
    void setHotOrNotRating(int rating); 
 
}