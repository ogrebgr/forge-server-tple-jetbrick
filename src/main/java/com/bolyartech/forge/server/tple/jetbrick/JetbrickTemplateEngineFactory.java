package com.bolyartech.forge.server.tple.jetbrick;

import com.bolyartech.forge.server.misc.TemplateEngine;
import com.bolyartech.forge.server.misc.TemplateEngineFactory;
import jetbrick.template.JetEngine;


public class JetbrickTemplateEngineFactory implements TemplateEngineFactory {
    private final String mTemplatePathPrefix;
    private final JetEngine mJetEngine;


    public JetbrickTemplateEngineFactory(String templatePathPrefix, JetEngine jetEngine) {
        mTemplatePathPrefix = templatePathPrefix;
        mJetEngine = jetEngine;
    }


    public JetbrickTemplateEngineFactory(String templatePathPrefix) {
        this(templatePathPrefix, JetEngine.create());
    }


    @Override
    public TemplateEngine createNew() {
        return new JetbrickTemplateEngine(mTemplatePathPrefix, mJetEngine);
    }
}
