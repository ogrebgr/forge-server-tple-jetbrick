package com.bolyartech.forge.server.tple.jetbrick;

import com.bolyartech.forge.server.misc.TemplateEngine;
import jetbrick.template.JetContext;
import jetbrick.template.JetEngine;
import jetbrick.template.JetTemplate;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;


public class JetbrickTemplateEngine implements TemplateEngine {
    private final String mTemplatePathPrefix;
    private final JetEngine mJetEngine;
    private final Map<String, Object> mAttributes = new HashMap<>();


    public JetbrickTemplateEngine(String templatePathPrefix, JetEngine jetEngine) {
        mJetEngine = jetEngine;
        mTemplatePathPrefix = templatePathPrefix;
    }


    @Override
    public void assign(String varName, Object object) {
        mAttributes.put(varName, object);
    }


    @Override
    public String render(String templateName) {
        JetTemplate template = mJetEngine.getTemplate(mTemplatePathPrefix + templateName);
        JetContext context = new JetContext(mAttributes.size());
        context.putAll(mAttributes);
        StringWriter writer = new StringWriter();
        template.render(context, writer);

        return writer.toString();
    }
}
