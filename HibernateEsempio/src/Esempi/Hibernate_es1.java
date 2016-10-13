package Esempi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import HibernateUtil.HibernateUtil;
import model.Indirizzo;
import model.Utente;

public class Hibernate_es1 {
	public static void main(String[] args){
		Utente u=new Utente(12,"AAAAA","AAAAA");
		Indirizzo i=new Indirizzo("Torino","fratelli carlè");
		u.setIndirizzo(i);
		
		u.addString("dddd");
		u.addString("ffff");
		u.addString("hhh");
		/*(1)
		Utente u1=new Utente();
		u1.setNome("AAAAA");
		u1.setCognome("AAAAA");

		Utente u2=new Utente();
		u2.setNome("BBBB");
		u2.setCognome("BBB");*/

		//(2)
		//		Utente u1=null;
		//		Utente u2=null;
		//	SessionFactory sf=new Configuration().configure().buildSessionFactory();//instanzio la sessionFactory per CREARE la tabella


		//Session session=sf.openSession();//apro la sessione

		//	session.beginTransaction();//inizio transazione
		//ACID=ATOMICITY(ovvero ATOMICITà ,tra le operazioni ci sono tutti i collegamenti)

		//(2)
		//session.delete(u);//per rimuoverlo
		//	u1=session.get(Utente.class, 12);//prendo dalla tabella se esiste quello con id=10
		//	u2=session.get(Utente.class, 13);
		//praticamente è come se facessi un select
		/*(1) session.save(u1);//l'oggetto che ho instanziato adesso viene salvato
		session.save(u2);*/

		//session.getTransaction().commit();

		//session.close();

		//System.out.println(u1.getNome()+" "+u1.getCognome());
		//System.out.println(u2.getNome()+" "+u2.getCognome());

		Session session=HibernateUtil.openSession();
		Transaction tx=null;

		try{
			tx=session.getTransaction();
			tx.begin();//inizio transazione
			u=session.get(u.getClass(), 1);
			//lavori da fare
			//session.delete(u);//se voglio rimuovere,ma vale anche per le altre operazioni
			session.save(u);
			
			tx.commit();//se la transazione è ok allora faccio commit
			//altrimenti catturo l'eccezione
		}catch(Exception ex){
			tx.rollback();//se nn va a buon fine torno indietro

		}finally{
			session.close();
		}
		System.out.println(u.getNome()+" "+u.getIndirizzo().getCittà());
		for(String s:u.getLista()){
			System.out.println(s);
		}
		



	}
}
