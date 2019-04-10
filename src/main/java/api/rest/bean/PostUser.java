package api.rest.bean;

public class PostUser {

	public String name;
	public String job;
	public String id;
	public String createdat;
	public String createdAt;
	
	
	public PostUser()
	{
		
	}
	public PostUser(String name,String job) {
		this.name=name;
		this.job=job;
	}
	
	/*public PostUser(String name,String job,String id,String createdat) {
		this.name=name;
		this.job=job;
		this.id=id;
		this.createdat=createdat;
	}*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatedat() {
		return createdat;
	}

	public void setCreatedat(String createdat) {
		this.createdat = createdat;
	}
	
	
}
