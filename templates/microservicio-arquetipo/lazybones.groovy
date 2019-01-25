import uk.co.cacoethes.util.NameType
import org.apache.commons.io.FileUtils

Map props = [:]
if (projectDir.name =~ /\-/) {
    props.project_class_name = transformText(projectDir.name, from: NameType.HYPHENATED, to: NameType.CAMEL_CASE)
} else {
    props.project_class_name = transformText(projectDir.name, from: NameType.PROPERTY, to: NameType.CAMEL_CASE)
}
props.project_name = transformText(props.project_class_name, from: NameType.CAMEL_CASE, to: NameType.HYPHENATED)

props.project_group = ask("Define value for 'group' [org.example]: ", "org.example", "group")
props.project_name = ask("Define value for 'artifactId' [" + props.project_name + "]: ", props.project_name , "artifactId")
props.project_version = ask("Define value for 'version' [0.1.0-SNAPSHOT]: ", "0.1.0-SNAPSHOT", "version")
props.project_package = ask("Define value for 'package' [" + props.project_group + "]: ", props.project_group, "package")
props.project_class_name = ask("Define value for 'className' [" + props.project_class_name + "]: ", props.project_class_name, "className").capitalize()
props.project_property_name = transformText(props.project_class_name, from: NameType.CAMEL_CASE, to: NameType.PROPERTY)
props.project_capitalized_name = props.project_property_name.capitalize()
props.microservicio_arquetipo = '1.0.1'
String packagePath = props.project_package.replace('.' as char, '/' as char)

processTemplates 'pom.xml', props

def renameFile = { File from, String path ->
    if (from.file) {
        File to = new File(path)
        to.parentFile.mkdirs()
        FileUtils.moveFile(from, to)
    }
}


['.'].each { it ->


    processTemplates '/src/main/java/**/*.java', props

    File mainSources = new File(projectDir, '/src/main/java')
    File mainResources = new File(projectDir,  '/src/main/resources')

    File mainSourcesPath = new File(mainSources, packagePath)
    File mainResourcesPath = new File(mainResources, packagePath)
    mainResourcesPath.mkdirs()

    mainSources.eachDir { File dir ->
        FileUtils.moveDirectoryToDirectory(dir, new File(mainSourcesPath.absolutePath), true)
    }

    mainSources.eachFile { File file ->
        renameFile(file, mainSourcesPath.absolutePath + '/' + file.name)
    }

    mainResources.eachFile { File file ->
        renameFile(file, mainResourcesPath.absolutePath + '/' + file.name)
    }
}