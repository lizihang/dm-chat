"use strict";(self["webpackChunkdm_chat_ui"]=self["webpackChunkdm_chat_ui"]||[]).push([[443],{6533:function(e,s,t){t.r(s),t.d(s,{default:function(){return y}});var l=t(3396),n=t(7139),o=t(9242);const a=e=>((0,l.dD)("data-v-a3ad5f7c"),e=e(),(0,l.Cn)(),e),r={class:"home"},u=a((()=>(0,l._)("h1",null,"简易聊天室",-1))),i=(0,l.Uk)("登出"),m={style:{width:"800px"}},c=(0,l.Uk)("toName"),d={ref:"innerRef"},g={key:0,class:"msg-send"},h={key:1,class:"msg-receive"},f=(0,l.Uk)("发送");function w(e,s,t,a,w,p){const _=(0,l.up)("el-button"),k=(0,l.up)("el-row"),W=(0,l.up)("el-header"),v=(0,l.up)("el-scrollbar"),y=(0,l.up)("el-col"),S=(0,l.up)("el-input"),N=(0,l.up)("el-main"),b=(0,l.up)("el-container");return(0,l.wg)(),(0,l.iD)("div",r,[(0,l.Wm)(b,null,{default:(0,l.w5)((()=>[(0,l.Wm)(W,{height:"65px",style:{padding:"0"}},{default:(0,l.w5)((()=>[(0,l.Wm)(k,null,{default:(0,l.w5)((()=>[u,(0,l.Wm)(_,{type:"primary",onClick:p.logout},{default:(0,l.w5)((()=>[i])),_:1},8,["onClick"])])),_:1}),(0,l.Wm)(k,null,{default:(0,l.w5)((()=>[(0,l.Uk)(" 欢迎 "+(0,n.zw)(w.username),1)])),_:1})])),_:1}),(0,l.Wm)(N,null,{default:(0,l.w5)((()=>[(0,l._)("div",m,[(0,l.Wm)(k,null,{default:(0,l.w5)((()=>[(0,l._)("p",null,[c,(0,l.wy)((0,l._)("input",{type:"text","onUpdate:modelValue":s[0]||(s[0]=e=>w.toName=e)},null,512),[[o.nr,w.toName]])])])),_:1}),(0,l.Wm)(k,null,{default:(0,l.w5)((()=>[(0,l.Wm)(y,{span:20,class:"msg-content"},{default:(0,l.w5)((()=>[(0,l.Wm)(v,{ref:"scrollbarRef",height:"400px",always:"",onScroll:p.scroll},{default:(0,l.w5)((()=>[(0,l._)("div",d,[((0,l.wg)(!0),(0,l.iD)(l.HY,null,(0,l.Ko)(w.msgList,(e=>((0,l.wg)(),(0,l.iD)("div",{key:e},[e.fromName===this.username?((0,l.wg)(),(0,l.iD)("p",g," 发送给"+(0,n.zw)(e.toName)+"："+(0,n.zw)(e.message),1)):((0,l.wg)(),(0,l.iD)("p",h," 接收到"+(0,n.zw)(e.fromName)+"："+(0,n.zw)(e.message),1))])))),128))],512)])),_:1},8,["onScroll"])])),_:1}),(0,l.Wm)(y,{span:4,class:"msg-content"},{default:(0,l.w5)((()=>[((0,l.wg)(!0),(0,l.iD)(l.HY,null,(0,l.Ko)(w.userList,(e=>((0,l.wg)(),(0,l.j4)(_,{class:"user-list-button",key:e,onClick:s=>p.chooseUser(e.username)},{default:(0,l.w5)((()=>[(0,l.Uk)((0,n.zw)(e.username),1)])),_:2},1032,["onClick"])))),128))])),_:1})])),_:1}),(0,l.Wm)(k,null,{default:(0,l.w5)((()=>[(0,l.Wm)(S,{type:"textarea",rows:2,modelValue:w.msg,"onUpdate:modelValue":s[1]||(s[1]=e=>w.msg=e)},null,8,["modelValue"]),(0,l.Wm)(_,{type:"primary",onClick:p.sendMsg},{default:(0,l.w5)((()=>[f])),_:1},8,["onClick"])])),_:1})])])),_:1})])),_:1})])}function p(e,s){const t=new WebSocket("ws://localhost:18080/chat/"+s),l=()=>{t.addEventListener("open",n,!1),t.addEventListener("close",o,!1),t.addEventListener("error",a,!1),t.addEventListener("message",e,!1)};function n(e){console.log("WebSocket open",e)}function o(e){console.log("WebSocket close",e)}function a(e){console.log("WebSocket error",e)}return l(),t}var _=p,k={name:"HomeView",data(){return{ws:{},username:"",toName:"",msg:"",count:10,msgList:[],userList:[{username:"admin"},{username:"dm"}]}},methods:{logout(){console.log("username:"+this.username),this.ws.close(),localStorage.removeItem("username"),this.$router.replace("/login")},sendMsg(){let e=this.msg;if(!e.trim())return;let s={fromName:this.username,toName:this.toName,message:this.msg};this.ws.send(JSON.stringify(s)),this.msgList.push(s),this.scrollAfterSend(),this.msg=""},handleMessage(e){console.log("接收到数据：",e);let s=JSON.parse(e.data);console.log(s),this.msgList.push(s),this.scrollAfterSend()},scrollAfterSend(){let e=this.$refs.innerRef.clientHeight;console.log("inner client height:",e),this.$nextTick((()=>{this.$refs.scrollbarRef.setScrollTop(e-320)}))},chooseUser(e){console.log("username：",e),this.toName=e},scroll(e){console.log(e)}},created(){this.username=localStorage.getItem("username"),this.ws=_(this.handleMessage,localStorage.getItem("username"))}},W=t(89);const v=(0,W.Z)(k,[["render",w],["__scopeId","data-v-a3ad5f7c"]]);var y=v}}]);
//# sourceMappingURL=about.67f89b8f.js.map