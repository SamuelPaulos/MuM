package chain;

public class ChainBuilder {
		public TemplateHandler getHandler() {
		// create templates handlers
		TemplateHandler archive = new ArchiveTemplate();
		TemplateHandler catagory = new CatagoryTemplate();
		TemplateHandler generic = new GenericTemplate();
		TemplateHandler image = new ImageTemplate();
		TemplateHandler single = new SingleTemplate();
		// create chain of responsibility and set successor if the request is
		// not hanlded
		image.successor = single;
		single.successor = catagory;
		catagory.successor = archive;
		archive.successor = generic;
		return image;
		
	}



}
