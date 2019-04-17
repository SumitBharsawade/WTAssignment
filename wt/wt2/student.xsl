
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
	<body>
		<table border="1">
		<tr bgcolor="#9acd32">
		<th>username</th>
		<th>password</th>
		<th>Firstname</th>
		<th>Lastname</th>
		<th>Gender</th>
		</tr>
		<xsl:for-each select="college/student">
		<tr>
		<td><xsl:value-of select="username"/></td>
		<td><xsl:value-of select="password"/></td>
		<td><xsl:value-of select="firstname"/></td>
		<td><xsl:value-of select="lastname"/></td>
		<td><xsl:value-of select="gender"/></td>
		</tr>
		</xsl:for-each>
		</table>
	</body>
</html>
</xsl:template>
</xsl:stylesheet>
