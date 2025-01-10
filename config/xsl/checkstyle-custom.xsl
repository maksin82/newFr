<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h2>Checkstyle Report</h2>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="file">
        <h3><xsl:value-of select="@name"/></h3>
        <ul>
            <xsl:apply-templates/>
        </ul>
    </xsl:template>

    <xsl:template match="error">
        <li>
            <xsl:value-of select="@line"/>
            :
            <xsl:value-of select="@message"/>
        </li>
    </xsl:template>
</xsl:stylesheet>
