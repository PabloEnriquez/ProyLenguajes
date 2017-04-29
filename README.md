# ProyLenguajes
para correrlo en eclipse, deben tener un servidor, yo tengo wildfly pero segun yo sirve con el q sea.
entonces importan el proyecto drools a eclipse y le ponen run on server
usando postman o algo similar si tienen otro, pueden hacer get y post.
ahorita tengo otras clases/objetos q usaba de ejemplo, eso de padre y hermano es de la tarea tons no lo tomen en cuenta; ahorita solo estudiante importa (y materia y tema, tal vez maestro lo podamos incluir). (src/main/java/com.trucutru.model)
ya en postman pueden ingresar estos json en este path(http://localhost:8080/restdrools/estudiantes/inserta), esto es POST:
{
	"nombre": "rafael del piero",
	"promedioGlobal": "85",
	"materiaCursando": {
		"nombre": "Grafs",
		"maestro": "Pedro marcos castenad",
		"promedioAlumno": "56",
		"porcentajeCompl": "25",
		"nivelCurso": "7",
		"tema": {
			"nombre": "MRUA",
			"nivel": "7"
		}
	}
}

{
	"nombre": "pedro paramo",
	"promedioGlobal": "55",
	"materiaCursando": {
		"nombre": "Grafs",
		"maestro": "Pedro marcos castenad",
		"promedioAlumno": "56",
		"porcentajeCompl": "25",
		"nivelCurso": "8",
		"tema": {
			"nombre": "MRUA",
			"nivel": "7"
		}
	}
}

{
	"nombre": "rafael del piero",
	"promedioGlobal": "87",
	"materiaCursando": {
		"nombre": "LP",
		"nivelCurso": "8"
	}
}

el resultado en postman es el mismo json, pero el resultado de las reglas lo ven en consola.
por ejemplo si meten:
{
	"nombre": "rafael del piero",
	"promedioGlobal": "87",
	"materiaCursando": {
		"nombre": "LP",
		"nivelCurso": "2"
	}
}
se les dispara la regla de "Inscripcion futura nivel bajo", q les pone en consola: rafael del piero, la materia: LP, es muy baja para tu nivel. este caso lo hice pensando en un estudiante q se quisiera inscribir en el futuro a una materia y asi, por le dice q es muy difícil para el o q no lo va a retar.

el archivo drl esta en src/main/resources/droolsrules. chequen ahi para algunas recomendaciones q hice

http://localhost:8080/restdrools/estudiantes con GET les da una lista de estudiantes


**********************************************
nuevo objeto json de prueba:
{
	"nombre": "pedro paramo",
	"promedioGlobal": "0.0",
	"materiasCursando": [{
		"nombre": "Fisica",
		"maestro": "Juan marcos castenad",
		"promedioAlumno": "0.0",
		"porcentajeCompl": "25",
		"nivelCurso": "7",
		"temas": [
			{
				"nombre": "MRUA",
				"nivel": "7",
				"ejercicios": [{
					"nombre": "tarea 1",
					"calif": "55",
					"dificultad": "8"
				}, {
					"nombre": "tarea 2",
					"calif": "45",
					"dificultad": "9"
				}, {
					"nombre": "tarea 3",
					"calif": "50",
					"dificultad": "6"
				}]
			}, {
				"nombre": "Caida Libre",
				"nivel": "5",
				"ejercicios": [{
					"nombre": "ejercicio 1",
					"calif": "66",
					"dificultad": "9"
				}, {
					"nombre": "tarea 1",
					"calif": "54",
					"dificultad": "7"
				}, {
					"nombre": "ejericio 2",
					"calif": "58",
					"dificultad": "6"
				}]
		}] 
	}, {
		"nombre": "Matematicas",
		"maestro": "Pedro lopez de silao",
		"promedioAlumno": "0.0",
		"porcentajeCompl": "35",
		"nivelCurso": "7",
		"temas": [
			{
				"nombre": "Divisiones",
				"nivel": "7",
				"ejercicios": [{
					"nombre": "tarea 1",
					"calif": "45",
					"dificultad": "8"
				}, {
					"nombre": "tarea 2",
					"calif": "55",
					"dificultad": "9"
				}, {
					"nombre": "tarea 3",
					"calif": "50",
					"dificultad": "6"
				}]
			}, {
				"nombre": "Limites",
				"nivel": "5",
				"ejercicios": [{
					"nombre": "ejercicio 1",
					"calif": "56",
					"dificultad": "9"
				}, {
					"nombre": "tarea 1",
					"calif": "34",
					"dificultad": "7"
				}, {
					"nombre": "ejericio 2",
					"calif": "38",
					"dificultad": "6"
				}]
		}]
	}]
}
