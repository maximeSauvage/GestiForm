package be.atc.gestiform.session.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import be.atc.gestiform.formation.entity.Formation;
import be.atc.gestiform.formation.service.FormationService;
import be.atc.gestiform.session.entity.Session;
import be.atc.gestiform.session.services.SessionService;
import be.atc.gestiform.util.JsfUtil;

@Component("sessionEditView")
@Scope("session")
public class SessionEditView {
	
	@Autowired
	SessionService SessionService;
	@Autowired
	FormationService formationService;

	/**
	 * the formation to edit
	 */
	private Session session;
	private SessionVO sessionVO;


	public SessionEditView() {
		initSession();
		initSessionVO();
	}
	
	private void initSessionVO(){
		if(sessionVO == null){
			sessionVO = new SessionVO();
		}
		
	}
	private void initSession(){
		if(session ==  null) {
			session = new Session();
		}
	}
	
	/**
	 * @return the session
	 */
	public Session getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(Session session) {
		this.session = session;
	}

	
	/**
	 * @return the sessionVO
	 */
	public SessionVO getSessionVO() {
		return sessionVO;
	}

	/**
	 * @param sessionVO the sessionVO to set
	 */
	public void setSessionVO(SessionVO sessionVO) {
		this.sessionVO = sessionVO;
		initSessionVO();
	}
	
    public List<Formation> completeFormation(String query) {
        //TODO optimize
        Iterable<Formation> allFormations = formationService.findAllFormation();
        List<Formation> filteredFormations = new ArrayList<>();
        
        System.out.println("query" + query);
         
        for (Formation formation : allFormations) {
			if(formation.getNom().toLowerCase().startsWith(query)){
				filteredFormations.add(formation);
				System.out.println("add formation " + formation.getNom());
			}
		}
         
        System.out.println(filteredFormations.size());
        return filteredFormations;
    }

	/**
	 * submit for the form of edited formation
	 * @return navigation
	 */
	public String submit() {
		initSession();
		System.out.println("sessionVO : " + sessionVO.getDateDebut() + "-" + sessionVO.getDateFin());
		System.out.println("session : " + session.getDebut() + "-" + session.getFin());
//		session = SessionService.save(session);
		System.out.println("session : " + session.getDebut() + "-" + session.getFin());
		return JsfUtil.SUCCESS;
	}
	
	public class SessionVO {
		private Date dateDebut=new Date();
		private Date dateFin=new Date();
		private String nbMaxApprenant="";
		private String formationId="";
		/**
		 * @return the dateDebut
		 */
		public Date getDateDebut() {
			return dateDebut;
		}
		/**
		 * @param dateDebut the dateDebut to set
		 */
		public void setDateDebut(Date dateDebut) {
			this.dateDebut = dateDebut;
		}
		/**
		 * @return the dateFin
		 */
		public Date getDateFin() {
			return dateFin;
		}
		/**
		 * @param dateFin the dateFin to set
		 */
		public void setDateFin(Date dateFin) {
			this.dateFin = dateFin;
		}
		/**
		 * @return the nbMaxApprenant
		 */
		public String getNbMaxApprenant() {
			return nbMaxApprenant;
		}
		/**
		 * @param nbMaxApprenant the nbMaxApprenant to set
		 */
		public void setNbMaxApprenant(String nbMaxApprenant) {
			this.nbMaxApprenant = nbMaxApprenant;
		}
		/**
		 * @return the formationId
		 */
		public String getFormationId() {
			return formationId;
		}
		/**
		 * @param formationId the formationId to set
		 */
		public void setFormationId(String formationId) {
			this.formationId = formationId;
		}
		
		
		
	}
}
