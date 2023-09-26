package hibernate_package;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class Authors {
	
		@Id
		private int authorId;
		private String authorName;
		@ManyToMany
		@JoinTable(name="Author_Books",joinColumns=@JoinColumn(name="authorId"),inverseJoinColumns=@JoinColumn(name="bookname"))
		
		private Set<Books> BookSet = new HashSet<Books>();
		public Authors() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getAuthorId() {
			return authorId;
		}
		public void setAuthorId(int authorId) {
			this.authorId = authorId;
		}
		public String getAuthorName() {
			return authorName;
		}
		public void setAuthorName(String authorName) {
			this.authorName = authorName;
		}
		public Set<Books> getBookSet() {
			return BookSet;
		}
		public void setBookSet(Set<Books> bookSet) {
			BookSet = bookSet;
		}
		
		
		

}
