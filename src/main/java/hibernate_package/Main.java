package hibernate_package;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

	public static void main(String[] args) {
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("Hibernate.config.xml").build();
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory sfactory=meta.buildSessionFactory();
		Session session=sfactory.openSession();
		
		Transaction t=session.beginTransaction();
		
		try {
			Authors a = new Authors();
			a.setAuthorId(111);
			a.setAuthorName("PremChand");

			Authors a1 = new Authors();
			a1.setAuthorId(112);
			a1.setAuthorName("JawaharLalNehru");
			
			Books b = new Books();
			b.setBookId(101);
			b.setBookName("Godan");
			
			Books b1 = new Books();
			b1.setBookId(102);
			b1.setBookName("Glimpses of World History");
			
			Books b2 = new Books();
			b2.setBookId(103);
			b2.setBookName("Discovery Of India");
			
			Books b3 = new Books();
			b3.setBookId(104);
			b3.setBookName("RanghBhoomi");
			
			a.getBookSet().add(b);
			a.getBookSet().add(b3);
			
			a1.getBookSet().add(b1);
			a1.getBookSet().add(b2);
			
			session.save(b);
			session.save(b1);
			session.save(b2);
			session.save(b3);
			
			session.save(a);
			session.save(a1);
			t.commit();
			
		}finally {
			sfactory.close();
			session.close();
			
		}

	}

}
