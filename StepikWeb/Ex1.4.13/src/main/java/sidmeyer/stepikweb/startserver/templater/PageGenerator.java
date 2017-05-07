package sidmeyer.stepikweb.startserver.templater;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

public class PageGenerator {
    private static final String TEMPLATES_DIR = "templates";
    private static PageGenerator pageGenerator;
    private final Configuration cfg;

    public static PageGenerator instance() {
        if (null == pageGenerator) {
            pageGenerator = new PageGenerator();
        }
        return pageGenerator;
    }

    public String getPage(String templatFileName, Map<String, Object> data) {
        Writer stream = new StringWriter();

        try {
            ClassTemplateLoader ctl = new ClassTemplateLoader(getClass(), File.separator + TEMPLATES_DIR); //Для загрузки шаблонов из jar
            cfg.setTemplateLoader(ctl);

            Template template = cfg.getTemplate(templatFileName);
            template.process(data, stream);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
        return stream.toString();
    }

    private PageGenerator() {
        cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
    }
}

