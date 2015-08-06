<?xml version="1.0" encoding="UTF-8"?>
<html xsl:version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<body style="font-family:Arial;font-size:15pt;background-color:#EEEEEE">
<div align="center" >
<p>
    <span style="font-style:italic">Employee CV</span>
</p>
</div>
<xsl:for-each select="employee">
  <div align="center" style="margin-left:20px;margin-bottom:1em;font-size:12pt">
   <span style="font-weight:bold;padding-top:5px;">Name: </span><xsl:value-of select="name"/><br></br>
   <span style="font-weight:bold;padding-top:5px">Email: </span><xsl:value-of select="email"/><br></br>
   <span style="font-weight:bold;padding-top:5px">Phone: </span><xsl:value-of select="phone"/><br></br>
   <span style="font-weight:bold;padding-top:5px">Job Title: </span><xsl:value-of select="jobTitle"/><br></br>
   <span style="font-weight:bold;padding-top:5px">Experience: </span><xsl:value-of select="experienceLevel"/><br></br>
<xsl:for-each select="skills/storedSnapshot/org.employee__manager.model.Skill">
<span style="font-weight:bold;padding-top:5px">Name: </span><xsl:value-of select="name"/><br></br>
<span style="font-weight:bold;padding-top:5px">Description: </span><xsl:value-of select="description"/><br></br>
<span style="font-weight:bold;padding-top:5px">Experience: </span><xsl:value-of select="experience"/><br></br>
</xsl:for-each>
  </div>
</xsl:for-each>
</body>
</html>