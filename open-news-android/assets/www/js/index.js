
Ext.setup({
    icon: 'icon.png',
    tabletStartupScreen: 'tablet_startup.png',
    phoneStartupScreen: 'phone_startup.png',
    glossOnIcon: false,
    onReady: function() {
    	
    	var reportButton =  new Ext.Button({
//    		style: 'background: transparent',
            ui  : 'decline',
            text: 'Report',
            
        });
    	var readButton =  new Ext.Button({
    		ui  : 'decline',
    		text: 'Read',
    	});
    	
    	var publishButton =  new Ext.Button({
    		ui  : 'decline',
    		badgeText : '1',
    		text: 'Publish',
    	});
    	var followUpButton =  new Ext.Button({
    		ui  : 'decline',
    		text: ' Follow Up',
    		centered: true,
    		iconCls: 'action',
    		iconMask: true
    		
    	});
        
    	// top
    	var topHbox = new Ext.Panel({
    		layout: {
    			type: 'hbox',
                pack: 'center'
            },
            flex: 1,
    		style:"border: 1px solid red ",
    		defaults: {
    			width: 120,
    			height:100,
    			margin: 10,
    			style: 'font-size: 0.8em',
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
            flex: 1,
    		style:"border: 1px solid green",
    		defaults: {
    			width: 120,
    			height:100,
    			margin: 10,
    			style: 'font-size: 0.8em',
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
            baseCls: 'bg',
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