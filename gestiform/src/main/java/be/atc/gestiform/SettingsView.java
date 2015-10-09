package be.atc.gestiform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import be.atc.gestiform.session.services.SessionService;
import be.atc.gestiform.session.services.TestSessionService;

@Component("settingsView")
@Scope("request")
public class SettingsView {
	
	@Autowired
	TestSessionService testSessionService;
	@Autowired
	SessionService sessionService;
	
	public void generateTestSessions() {
		testSessionService.initTestSessionDates();
	}
	
	public void organizeSession() {
		testSessionService.organizeSession();
		sessionService.organizeSession();
	}

}