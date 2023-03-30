# Listado de errores

A continuación se muestra el listado del incumplimiento de los principios SOLID encontrados en el ejercicio. Cada uno de ellos tiene asignado un **identificador** que los asocia con su commit correspondiente, en el caso de haberse efectuado cambios en el código.  
  
---
## [Error 01]
### Principio de Sustitución de Liskov

los métodos "listFiles", "addFile" y "removeFile" de la clase "File" lanzan una excepción que incumple con la norma de no poder lanzar excepciones que no lance su antecesora ("FileSystemItem"). El código que la usa no podrá gestionar las excepciones.

```js
@Override
    public List<FileSystemItem> listFiles() {
        throw new UnsupportedOperationException("No es válido para ficheros");
    }

    @Override
    public void addFile(FileSystemItem file) {
        throw new UnsupportedOperationException("No es válido para ficheros");
    }

    @Override
    public void removeFile(FileSystemItem file) {
        throw new UnsupportedOperationException("No es válido para ficheros");
    }

```
---

## [Error 02]
### Principio de Responsabilidad Única
La clase “File” tiene demasiadas responsabilidades. Se podrían dividir en varias clases que gestionen:
- Cómo representar el archivo.
- Cómo manejar su contenido y su tamaño.
- Cónversión de formatos de archivo.

---

## [Error 03]
### Principio de Inversión de Dependencias 
La clase “File” depende directamente de una clase concreta, la clase **“InvalidFileFormatException”**. En su lugar debería depender de abstracciones y no de implementaciones concretas.

```js
public  class File extends FileSystemItemBase implements FileSystemItem 
```
---

## [Error 04]
### Principio de Segregación de Interfaz
**“FileSystemItem”** contiene métodos que no se usan para todos los tipos de archivos. Se podrían crear dos interfaces; una para trabajar con **“Files”** y otra para **“Directory”**.

---

## [Error 05]
### Principio de abierto cerrado
Lo incumple también la interfaz **“FileSystemItem”**, por esta serie de métodos de los que hablamos en el [Error 04]. Si en el futuro añadiéramos otro método que solo sea útil para **“Directory”**, la clase **“File”** se verá obligada también a cambiar para adaptarse a la nueva funcionalidad. La solución es la misma para ambos errores; crear una interfaz para trabajar con cada clase.

---

## [Error 06]
### Principio de Inversión de Dependencias
La clase **“Directory”** depende directamente de la clase concreta **“FileSystemItemBase”** en lugar de depender de la abstracción **“FileSystemItem”**.

```js
public class Directory extends FileSystemItemBase implements FileSystemItem
```