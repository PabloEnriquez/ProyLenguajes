# ProyLenguajes
para correrlo en eclipse, deben tener un servidor, yo tengo wildfly pero segun yo sirve con el q sea.
entonces importan el proyecto drools a eclipse y le ponen run on server
usando postman o algo similar si tienen otro, pueden hacer get y post.
ahorita tengo otras clases/objetos q usaba de ejemplo, eso de padre y hermano es de la tarea tons no lo tomen en cuenta; ahorita solo estudiante importa.
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
