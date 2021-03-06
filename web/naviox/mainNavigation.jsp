<%@include file="../xava/imports.jsp"%>

<%@page import="java.util.Iterator"%>
<%@page import="org.openxava.application.meta.MetaModule"%>
<%@page import="org.openxava.util.Users"%>
<%@page import="org.openxava.util.Is"%>
<%@page import="com.openxava.naviox.Modules"%>
<%@page import="com.openxava.naviox.util.NaviOXPreferences"%>

<jsp:useBean id="modules" class="com.openxava.naviox.Modules" scope="session"/>

<span style="float: left;">
<% if (modules.hasModules()) { %>
<a id="show_modules" href=""><xava:message key="all_modules"/></a>
<% } %>

<% 
for (Iterator it= modules.getTopModules().iterator(); it.hasNext();) {
	MetaModule module = (MetaModule) it.next();
	if (module.getName().equals("SignIn")) continue; 
		String selected = module.getName().equals(request.getParameter("module"))?"selected":"";
%>		
	<a  href="/<%=module.getMetaApplication().getName()%>/m/<%=module.getName()%>" class="<%=selected%>">
		<%=module.getLabel(request.getLocale())%>
	</a>
	
<%
	
}
%>
</span>

<span style="float: right;">
<%
if (Is.emptyString(NaviOXPreferences.getInstance().getAutologinUser())) { 
	String userName = Users.getCurrent();
	if (userName == null) {
%>
<% String selected = "SignIn".equals(request.getParameter("module"))?"selected":""; %>
<a href="<%=request.getContextPath()%>/m/SignIn" class="sign-in <%=selected%>">
		<xava:message key="signin"/>
</a>
<%
	}
	else {
%>
<a  href="<%=request.getContextPath()%>/naviox/signOut.jsp" class="sign-in"><xava:message key="signout"/> (<%=userName%>)</a>
<%
	}
} 
%>
</span>