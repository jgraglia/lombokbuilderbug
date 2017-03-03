#Bug

The BuilderDemo is a simple demo for a bug hitting me when using @Builder annotation.

It appears (a NPE in ArrayList.addAll) when I use the toBuilder() method of an instance containing a null **SINGULARIZED** collection( or map).

Note : if I remove the @Singular annotation, the NPE is not thrown (see _should_not_NPE_on_NOT_singularized_item_when_using_toBuilder_from_an_instance_created_with_a_null_collection_) 


Test stack trace : 

    java.lang.NullPointerException
        at java.util.ArrayList.addAll(ArrayList.java:577)
        at BuilderDemo$BuilderDemoBuilder.singularNames(BuilderDemo.java:51)
        at BuilderDemo.toBuilder(BuilderDemo.java:100)
        at BuilderDemoTest.should_not_NPE_on_singularized_item_when_using_toBuilder_from_an_instance_created_with_a_null_collection(BuilderDemoTest.java:21)
	
Generated source code (thx delombok plugin)

        @SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        public BuilderDemoBuilder singularNames(final java.util.Collection<? extends String> singularNames) {
            if (this.singularNames == null) this.singularNames = new java.util.ArrayList<String>();
            this.singularNames.addAll(singularNames);
            return this;
        }
        
the NPE is thrown at line _this.singularNames.addAll(singularNames);_ : the _singularNames_ parameter is null, and ArrayList.addAll does not support null param.
 
See #src/test/java/BuilderDemoTest.java 