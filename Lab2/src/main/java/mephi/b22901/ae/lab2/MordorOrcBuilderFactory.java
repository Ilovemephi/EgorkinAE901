package mephi.b22901.ae.lab2;


public class MordorOrcBuilderFactory implements OrcBuilderFactory {

    @Override
    public OrcBuilder createOrcBuilder() {
        return new MordorOrcBuilder(new MordorGearFactory());
    }
    
    
}
