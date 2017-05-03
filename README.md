# ProyLenguajes
para correrlo en eclipse, deben tener un servidor, yo tengo wildfly pero segun yo sirve con el q sea.
entonces importan el proyecto drools a eclipse y le ponen run on server. Debe decirles en consola q no hay pedos, osea INFO o WARN maximo; y se abrirá una pestana de explorador en eclipse para que sepan q ya está corriendo.
Si sale ERROR pues ya ahi pasa algo. No se preocupen por la pestana de explorador que abre eclipse automáticamente si dice not found o algo asi, el chiste es probarlo con postman. si ya ahi no les responde con un objeto json hay problemas. 
usando postman o algo similar si tienen otro, pueden hacer get y post.
ahorita tengo otras clases/objetos q usaba de ejemplo, eso de padre y hermano es de la tarea tons no lo tomen en cuenta; ahorita solo estudiante importa (y materia y tema, tal vez maestro lo podamos incluir). (src/main/java/com.trucutru.model)

**********************************************

Instrucciones para pruebas en Postman:

-> -> endpoint: http://localhost:8080/restdrools/estudiantes/inserta con POST
ejemplos estudiante:
1: buen historial
{
	"nombre": "jose lopez portillo",
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
					"calif": "65",
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
				"nombre": "Caida Libre",
				"nivel": "5",
				"ejercicios": [{
					"nombre": "ejercicio 1",
					"calif": "66",
					"dificultad": "9"
				}, {
					"nombre": "tarea 1",
					"calif": "64",
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
					"calif": "100",
					"dificultad": "8"
				}, {
					"nombre": "tarea 2",
					"calif": "100",
					"dificultad": "9"
				}, {
					"nombre": "tarea 3",
					"calif": "100",
					"dificultad": "6"
				}]
			}, {
				"nombre": "Limites",
				"nivel": "5",
				"ejercicios": [{
					"nombre": "ejercicio 1",
					"calif": "100",
					"dificultad": "9"
				}, {
					"nombre": "tarea 1",
					"calif": "100",
					"dificultad": "7"
				}, {
					"nombre": "ejercicio 2",
					"calif": "100",
					"dificultad": "6"
				}]
		}]
	}],
	"recomendaciones": []
}
------
2: reprobatorio
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
					"nombre": "ejercicio 2",
					"calif": "38",
					"dificultad": "6"
				}]
		}]
	}],
	"recomendaciones": []
}
 -> -> endpoint: http://localhost:8080/restdrools/estudiantes/prediccion con POST
 ejemplos estudiantes inscripcion
 1:
 {
	"nombre": "jose lopez portillo",
	"promedioGlobal": "79.833",
	"materiaAInscribir": {
	"nombre" : "PA",
	"nivelCurso": "2"
	},
	"recomendaciones": []
}
2:
{
	"nombre": "jose lopez portillo",
	"promedioGlobal": "79.833",
	"materiaAInscribir": {
	"nombre" : "PA",
	"nivelCurso": "8"
	},
	"recomendaciones": []
}

-> -> endpoint: http://localhost:8080/restdrools/estudiantes/1 con GET
el 1 es el id, entonces cualquier id de estudiante existente te regresa el estudiante correspondiente.
Si no existe te regresa null, pero en Postman se ve vacio

-> -> endpoint: http://localhost:8080/restdrools/estudiantes con GET
te da la lista completa de estudiantes existente en la knowledge base de drools
