
var App = new Ext.Application({
    name : 'agendaApp',
    useLoadMask : true,
    launch : function () {
    	
    	
    	/*reportEditor start*/
    	agendaApp.views.reportEditorTopToolbar = new Ext.Toolbar({
    	    title: 'Edit Report',
    	    items: [
    	        {
    	            text: 'Home',
    	            ui: 'back',
    	            handler: function () {
    	            	agendaApp.views.viewPort.setActiveItem('homePanel', {type: 'slide', direction: 'right'});
    	            }
    	        },
    	        { xtype: 'spacer' },
    	        {
    	            text: 'Save',
    	            ui: 'action',
    	            handler: function () {
    	                // TODO: Save current note.
    	            }
    	        }
    	    ]
    	});

    	agendaApp.views.reportEditorBottomToolbar = new Ext.Toolbar({
    	    dock: 'bottom',
    	    items: [
    	        { xtype: 'spacer' },
    	        {
    	            iconCls: 'trash',
    	            iconMask: true,
    	            handler: function () {
    	                // TODO: Delete current note.
    	            }
    	        }
    	    ]
    	});

    	agendaApp.views.reportEditor = new Ext.form.FormPanel({
    	    id: 'reportEditor',
    	    items: [
	            {
	            	xtype: 'textfield',
	            	name: 'id',
	            	label: 'Id',
	            	disabled: true
	            	
	            },
    	        {
    	            xtype: 'textfield',
    	            name: 'title',
    	            label: 'Title',
    	            required: true
    	        },
    	        {
    	            xtype: 'textareafield',
    	            name: 'content',
    	            label: 'Content'
    	        }
    	    ],
    	    
    	    dockedItems: [
    	            agendaApp.views.reportEditorTopToolbar,
    	            agendaApp.views.reportEditorBottomToolbar
    	        ]
    	        

    	});
    	/*reportEditor end*/
    	
    	
    	/*Read Container*/
    	/**
    	 * 
    	 */

    	agendaApp.views.reportList = new Ext.List({
    	    id: 'reportList',
    	    store: 'ReportsStore',
    	    itemTpl: '<div class="list-item-title">{title}</div>' +
    	    		 '<div class="list-item-narrative">{content}</div>',
    	    onItemDisclosure: function (record) {
    	    		alert('onItemDisclosure');
    	    	    }

    	});

    	agendaApp.views.reportListToolbar = new Ext.Toolbar({
    	    id: 'reportListToolbar',
    	    title: 'Reports',
    	    layout: 'hbox',
    	    items: [
    	        
    	        {
    	            id: 'backButton',
    	            text: 'Home',
    	            ui: 'back',
    	            handler: function () {
    	            	agendaApp.views.viewPort.setActiveItem('homePanel', {type: 'slide', direction: 'right'});
    	            }
    	        },
    	        { xtype: 'spacer' }
    	    ]
    	});

    	agendaApp.views.readContainer = new Ext.Panel({
    		id: 'readContainer',
    	    fullscreen : true,
    	    layout : 'fit',
    	    cardAnimation : 'slide',
    	    html: "this is read panel",
    		items: [
    		        
    	            ],
    		dockedItems: [agendaApp.views.reportListToolbar],
    		items: [agendaApp.views.reportList]

    	});

    	/*Read Container*/
    	
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
	   	        	
	   	        	var now = new Date();
	                 var noteId = now.getTime();
	                 var note = Ext.ModelMgr.create(
	                     { id: noteId, date: now, title: 'sss', content: 'aaaa' },
	                     'Report'
	                 );

	                 agendaApp.views.reportEditor.load(note);
	                 agendaApp.views.viewPort.setActiveItem("reportEditor", {type: 'slide', direction: 'left'});


	   	        	
	   	        
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
	        	agendaApp.views.viewPort.setActiveItem('readContainer', {type: 'slide', direction: 'left'});
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
    			style: 'font-size: 0.8em ;margin-bottom: 20% ',
             },
    		items:[
					publishButton,
					followUpButton
    		       ]
    			});
    	
    	agendaApp.views.homeToolbar = new Ext.Toolbar({
    	    title: 'AgendaList',
    	    xtype: 'toolbar',
    	    items: [
    	        {
    	        	iconMask: true,
    	            iconCls: 'action', 
    	            ui: 'plain',
    	            handler: function () {
    	            	alert("are you sure you wanna leave?");
    	            }
    	        },
    	        { xtype: 'spacer' },
    	        {
    	        	iconMask: true,
    	            iconCls: 'refresh', 
    	            ui: 'plain',
    	            handler: function () {
    	                // TODO: Transition to the notes list view.
    	            }
    	        },
    	    ]
    	});
    	
    	
    	agendaApp.views.home = new Ext.Panel({
    		id: 'homePanel',
    		
    		
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
    		items: [
    		        topHbox,
    		        bottomHbox
    	            ],
    	    dockedItems: [
    	                  agendaApp.views.homeToolbar
    	                  ]
    	});
    	
    	agendaApp.views.viewPort = new Ext.Panel({
    		            fullscreen: true,
    		            layout: 'card',
    		            cardAnimation: 'slide',
    		            items: [
    		                    agendaApp.views.home,
    		                    agendaApp.views.readContainer,
    		                    agendaApp.views.reportEditor,
    		            ]
    		        });

    }



});







    	
    	
