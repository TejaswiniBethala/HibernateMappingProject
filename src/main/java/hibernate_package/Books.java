package hibernate_package;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Books {
	
		@Id
		private int BookId;
		private String BookName;
		
		@ManyToMany(mappedBy="BookSet")
		
		private Set<Authors> authorSet = new HashSet<Authors>();

		public Books() {
			super();
			// TODO Auto-generated constructor stub
		}

		public int getBookId() {
			return BookId;
		}

		public void setBookId(int bookId) {
			BookId = bookId;
		}

		public String getBookName() {
			return BookName;
		}

		public void setBookName(String bookName) {
			BookName = bookName;
		}

		public Set<Authors> getAuthorSet() {
			return authorSet;
		}

		public void setAuthorSet(Set<Authors> authorSet) {
			this.authorSet = authorSet;
		}
		

}
