package ee.ssm.en;

public class Movie {
	int mid;
	String name;
	String director;
	String actor;
	String distrit;
	String date;
	String pic_url;
	String m_url;
	String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getDistrit() {
		return distrit;
	}
	public void setDistrit(String distrit) {
		this.distrit = distrit;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPic_url() {
		return pic_url;
	}
	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}
	public String getM_url() {
		return m_url;
	}
	public void setM_url(String m_url) {
		this.m_url = m_url;
	}


	@Override
	public String toString() {
		return "Movie{" +
				"mid=" + mid +
				", name='" + name + '\'' +
				", director='" + director + '\'' +
				", actor='" + actor + '\'' +
				", distrit='" + distrit + '\'' +
				", date='" + date + '\'' +
				", pic_url='" + pic_url + '\'' +
				", m_url='" + m_url + '\'' +
				", type='" + type + '\'' +
				'}';
	}
}
