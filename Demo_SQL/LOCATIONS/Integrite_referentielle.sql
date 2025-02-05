-- INTEGRITE REFERENTIELLE

ALTER TABLE Employes WITH CHECK ADD
	CONSTRAINT FK_Employes_CodeService FOREIGN KEY(CodeService)
		REFERENCES Services(CodeService),
	CONSTRAINT FK_Employes_CodeChef FOREIGN KEY(CodeChef)
		REFERENCES Employes(CodeEmp);


ALTER TABLE Conges WITH CHECK ADD
	CONSTRAINT FK_Conges_Employe_CodeEmp FOREIGN KEY(CodeEmp)
		REFERENCES Employes(CodeEmp);

ALTER TABLE Conges_Mens WITH CHECK ADD
	CONSTRAINT FK_Conges_Mens FOREIGN KEY(CodeEmp, Annee)
		REFERENCES Conges(CodeEmp, Annee);

-- SUPPRIMER LES CONTRAINTE D'INTEGRITE REFERENTIELLE

ALTER TABLE Conges DROP 
	CONSTRAINT FK_Conges_Employe_CodeEmp;

ALTER TABLE Employes DROP 
	CONSTRAINT FK_Employes_CodeService,
	CONSTRAINT FK_Employes_CodeChef;

ALTER TABLE Conges_Mens DROP 
	CONSTRAINT FK_Conges_Mens;

-- SUPPRIMER TABLEAU

DROP TABLE Conges_Mens, Conges, Employes, Services;
