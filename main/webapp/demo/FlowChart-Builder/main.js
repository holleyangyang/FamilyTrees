
function addNode(parentId, nodeId, nodeLable, position) {
  var panel = d3.select("#" + parentId);
  panel.append('div').style('width','120px').style('height','50px')
    .style('position','absolute')
    .style('top',position.y).style('left',position.x)
    .style('border','2px #9DFFCA solid').attr('align','center')
    .attr('id',nodeId).classed('node',true)
    .text(nodeLable);

  return jsPlumb.getSelector('#' + nodeId)[0];
}

function addPorts(instance, node, ports, type) {
  //Assume horizental layout
  var number_of_ports = ports.length;
  var i = 0;
  var height = $(node).height();  //Note, jquery does not include border for height
  var y_offset = 1 / ( number_of_ports + 1);
  var y = 0;

  for ( ; i < number_of_ports; i++ ) {
    var anchor = [0,0,0,0];
    var paintStyle = { radius:5, fillStyle:'#FF8891' };
    var isSource = false, isTarget = false;
    if ( type === 'output' ) {
      anchor[0] = 1;
      paintStyle.fillStyle = '#D4FFD6';
      isSource = true;
    } else {
      isTarget =true;
    }

    anchor[1] = y + y_offset;
    y = anchor[1];

    instance.addEndpoint(node, {
      uuid:node.getAttribute("id") + "-" + ports[i],
      paintStyle: paintStyle,
      anchor:anchor,
      maxConnections:-1,
      isSource:isSource,
      isTarget:isTarget
    });
  }
}

function connectPorts(instance, node1, port1, node2 , port2) {
  // declare some common values:
  var color = "gray";
  var arrowCommon = { foldback:0.8, fillStyle:color, width:5 },
  // use three-arg spec to create two different arrows with the common values:
  overlays = [
    [ "Arrow", { location:0.8 }, arrowCommon ],
    [ "Arrow", { location:0.2, direction:-1 }, arrowCommon ]
  ];

  var uuid_source = node1.getAttribute("id") + "-" + port1;
  var uuid_target = node2.getAttribute("id") + "-" + port2;

  instance.connect({uuids:[uuid_source, uuid_target]});
}

function getTreeData() {
  var tree = [
    {
      text: "Nodes",
      nodes: [
        {
          text: "Node122",
        },
        {
          text: "Node2"
        }
      ]
    }
  ]; 

  return tree;
}

jsPlumb.ready(function() {
    console.log("jsPlumb is ready to use");

    //Initialize JsPlumb
    var color = "#E8C870";
    var instance = jsPlumb.getInstance({
      // notice the 'curviness' argument to this Bezier curve.  the curves on this page are far smoother
      // than the curves on the first demo, which use the default curviness value.      
      Connector : [ "Bezier", { curviness:50 } ],
      DragOptions : { cursor: "pointer", zIndex:2000 },
      PaintStyle : { strokeStyle:color, lineWidth:2 },
      EndpointStyle : { radius:5, fillStyle:color },
      HoverPaintStyle : {strokeStyle:"#7073EB" },
      EndpointHoverStyle : {fillStyle:"#7073EB" },
      Container:"flow-panel"
    });

    //Initialize Control Tree View
    $('#control-panel').treeview({data: getTreeData()});
    
    //Handle drag and drop
    $('.list-group-item').attr('draggable','true').on('dragstart', function(ev){
      //ev.dataTransfer.setData("text", ev.target.id);
      ev.originalEvent.dataTransfer.setData('text',ev.target.textContent);
      console.log('drag start');
    });

    $('#flow-panel').on('drop', function(ev){
      
      //avoid event conlict for jsPlumb
      if (ev.target.className.indexOf('_jsPlumb') >= 0 ) {
        return;
      }

      ev.preventDefault();
      var mx = '' + ev.originalEvent.offsetX + 'px';
      var my = '' + ev.originalEvent.offsetY + 'px';

      console.log('on drop : ' + ev.originalEvent.dataTransfer.getData('text'));
      var uid = new Date().getTime();
      var node = addNode('flow-panel','node' + uid, 'node', {x:mx,y:my});
      addPorts(instance, node, ['out'],'output');
      addPorts(instance, node, ['in1','in2'],'input');
      instance.draggable($(node));
    }).on('dragover', function(ev){
      ev.preventDefault();
      console.log('on drag over');
    });
  
    instance.doWhileSuspended(function() {

      // declare some common values:
      var arrowCommon = { foldback:0.8, fillStyle:color, width:5 },
      // use three-arg spec to create two different arrows with the common values:
      overlays = [
        [ "Arrow", { location:0.8 }, arrowCommon ],
        [ "Arrow", { location:0.2, direction:-1 }, arrowCommon ]
      ];
      //step 1 
      //1-1 .do
      var doNode1 = addNode('flow-panel','do1', '.do', {x:'80px',y:'20px'});
      //1-2 .do输出点
      addPorts(instance, do1, ['out1','out2'],'output');
      
      //step 2  
      //2-1 action
      var actionNode1 = addNode('flow-panel','action1', 'action1', {x:'240px',y:'20px'});
      //2-2 action1输入点
      addPorts(instance, actionNode1, ['in'],'input');
      //2-3 action1输出点
      addPorts(instance, actionNode1, ['out1'],'output');
      //2-4 .do关联action
      connectPorts(instance, doNode1, 'out1', actionNode1, 'in');
      
      
      var actionNode2 = addNode('flow-panel','action2', 'action2', {x:'240px',y:'100px'});
      //action2 输入点
      addPorts(instance, action2, ['in'],'input');
      
      connectPorts(instance, doNode1, 'out2', actionNode2, 'in');
      
      //step 3
      //3-1 service
      var serviceNode1 = addNode('flow-panel','service1', 'service1', {x:'400px',y:'20px'});
      //3-2 service输出点、action输入点
      addPorts(instance, serviceNode1, ['in'],'input');
      //3-3 action关联service
      connectPorts(instance, actionNode1, 'out1', serviceNode1, 'in');
      

      
      instance.draggable($('.node'));
  
    });

    jsPlumb.fire("jsFlowLoaded", instance);
    
});