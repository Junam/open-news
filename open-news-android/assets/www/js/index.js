
Ext.setup({
    icon: 'icon.png',
    tabletStartupScreen: 'tablet_startup.png',
    phoneStartupScreen: 'phone_startup.png',
    glossOnIcon: false,
    onReady: function() {
    	
    	var reportButton =  new Ext.Panel({
    		cls: "homeBtn",
    		flex: 1,
            html: "<div >" +
            		"<div style='height:60%; text-align: center;'>" +
            			"<img  src='images/newreport.png' class='home-btn-img'/>" +
    				"</div>" + 
    				"<div class='home-btn-label-wrapper'>" +
            			"<div class='home-btn-label'>" + 
            				"<span class='btn-title'>NEW REPORT</span>"+
            				"<br/>" +
            				"<span class='badge' >4</span>" +
            				" new reports near you " + 
        				"</div>" +
    				"</div>" +
           		"</div>",
	   		listeners: {
	   	        click: function()
	   	        {
	   	        	
	   	        	this.dom.parentNode.setAttribute("class", "shadow")
	   	        	
	   	        
	   	        },
	   	        element: 'body'
	   	    },
        });
    	var readButton =  new Ext.Panel({    		
    		
    		cls: "homeBtn",
    		flex: 1,
            html: "<div>" +
    		"<div style='height:60%; text-align: center;'>" +
    			"<img src='images/read.png' class='home-btn-img'/>" +
			"</div>" + 
			"<div class='home-btn-label-wrapper'>" +
    			"<div class='home-btn-label'>" + 
    			"<span class='btn-title'>READ</span>"+
    				"<br/>" +
    				"<span class='badge' >4</span>" +
    				" new reports near you " + 
				"</div>" +
			"</div>" +
   		"</div>",
		listeners: {
	        click: function()
	        {
	        	this.dom.setAttribute("class", "shadow")
	        	
	        
	        },
	        element: 'body'
	    },
	    });
    	
    	var publishButton =  new Ext.Panel({
    		cls: "homeBtn",
    		flex: 1,
            html: "<div>" +
            		"<div style='height:60%; text-align: center;'>" +
            			"<img src='images/publish.png' class='home-btn-img'/>" +
    				"</div>" + 
    				"<div class='home-btn-label-wrapper'>" +
            			"<div class='home-btn-label'>" + 
            			"<span class='btn-title'>PUBLISH</span>"+
            				"<br/>" +
            				"<span class='badge' >4</span>" +
            				" new reports near you " + 
        				"</div>" +
    				"</div>" +
           		"</div>",
	   		listeners: {
	   	        click: function()
	   	        {
	   	        	this.dom.setAttribute("class", "shadow")
	   	        	
	   	        
	   	        },
	   	        element: 'body'
	   	    },
            
        });
    	var followUpButton =  new Ext.Panel({
    		cls: "homeBtn",
    		flex: 1,
            html: "<div>" +
            		"<div style='height:60%; text-align: center;'>" +
            			"<img src='images/followup.png' class='home-btn-img'/>" +
    				"</div>" + 
    				"<div class='home-btn-label-wrapper'>" +
            			"<div class='home-btn-label'>" + 
            			"<span class='btn-title'>FOLLOW UP</span>"+
            				"<br/>" + 
            				"<span class='badge' >4</span>" +
            				" new reports near you " + 
        				"</div>" +
    				"</div>" +
           		"</div>",
	   		listeners: {
	   	        click: function()
	   	        {
	   	        	this.dom.setAttribute("class", "shadow")
	   	        	
	   	        
	   	        },
	   	        element: 'body'
	   	    },
            
        });
        
    	// top
    	var topHbox = new Ext.Panel({
    		layout: {
    			type: 'hbox',
                pack: 'center'
            },
            flex: 2,
    		style:"",
    		defaults: {
//    			width: 230,
//    			height:200,
//    			margin: 10,
    			style: 'font-size: 0.8em; margin-top: 20%;',
             },
    		items:[
    		       reportButton,
    		       readButton
    		       ]
    			
    			});

    	// bottom
    	var bottomHbox = new Ext.Panel({
    		layout: {
    			type: 'hbox',
                pack: 'center'
            },
            flex: 2,
    		style:"",
    		defaults: {
//    			width: 230,
//    			height:200,
//    			margin: 10,
    			style: 'font-size: 0.8em ;margin-bottom: 20% ',
             },
    		items:[
					publishButton,
					followUpButton
    		       ]
    			});
    	
    	var mainPanel = new Ext.Panel({
    		fullscreen: true,
    		layout: {
    			type: 'vbox',
                pack: 'center'
            },
            html: 
    		"<div style='position:absolute; z-index:0;height:100%; width:100%; text-align: center;'>" +
    			"<img src='images/blue.jpg' style='height:99%; width:99%;'/>" +
			"</div>",
            defaults: {
            	
            	
            },
//            baseCls: 'bg',
    		items: [
    		        topHbox,
    		        bottomHbox
                    ],
            dockedItems: [{
                xtype: 'toolbar',
                dock: 'top',
                defaults: {
                    ui: 'plain'
                },
                scroll: 'horizontal',
                layout: {
                    pack: 'center'
                },
                defaults: {
                    iconMask: true,
                    ui: 'plain',
                },
                items: [{
                    iconCls: 'action',
                	text: 'asd'
                	}
                ]
            }]
    	});
    	/*
    	var mainPanel = new Ext.TabPanel({
            fullscreen: true,
            // type: 'light',
            tabBar: {
                dock: 'bottom',
                scroll: 'horizontal',
                sortable: true,
                layout: {
                    pack: 'center'
                }
            },
            cls: 'card1',
            html: 'Both toolbars and tabbars have built-in, ready to use icons. Styling custom icons is no hassle.<p><small>If you cant see all of the buttons below, try scrolling left/right.</small></p>',
            items: [
                { iconCls: 'bookmarks', title: 'Bookmarks'},
                { iconCls: 'download', title: 'Download' },
                { iconCls: 'favorites', title: 'Favorites' },
                { iconCls: 'info', title: 'Info' },
                { iconCls: 'more', title: 'More' },
                { iconCls: 'search', title: 'Search' },
                { iconCls: 'settings', title: 'Settings' },
                { iconCls: 'team', title: 'Team' },
                { iconCls: 'time', title: 'Time' },
                { iconCls: 'user', title: 'User' }
            ],
            dockedItems: [{
                xtype: 'toolbar',
                dock: 'top',
                defaults: {
                    ui: 'plain'
                },
                scroll: 'horizontal',
                layout: {
                    pack: 'center'
                },
                defaults: {
                    iconMask: true,
                    ui: 'plain'
                },
                items: [{
                    iconCls: 'action'
                }, {
                    iconCls: 'add'
                }, {
                    iconCls: 'arrow_up'
                }, {
                    iconCls: 'arrow_right'
                }, {
                    iconCls: 'arrow_down'
                }, {
                    iconCls: 'arrow_left'
                }, {
                    iconCls: 'compose'
                }, {
                    iconCls: 'delete'
                }, {
                    iconCls: 'refresh'
                }, {
                    iconCls: 'reply'
                }, {
                    iconCls: 'search'
                }, {
                    iconCls: 'star'
                }, {
                    iconCls: 'trash'
                }]
            }]
        });*/
    }
});