organization := "com.github.biopet"
name := "biopet-tools"

scalaVersion := "2.11.11"

resolvers += Resolver.mavenLocal

lazy val biopetTools = (project in file("."))
  .aggregate(
    XcnvToBed,
    WipeReads,
    VepNormalizer,
    VcfWithVcf,
    VcfToTsv,
    VcfFilter,
    ValidateVcf,
    ValidateFastq,
    ValidateAnnotation,
    SnptestToVcf,
    ReplaceContigsVcffile,
    ReplaceContigsGtffile,
    MergeOtuMaps,
    CountAlleles,
    NcbiReporttoContigMap,
    MultiCoverage,
    MpileupToVcf,
    KrakenReportToJson,
    GvcfToBed,
    GtftoRefflat,
    FindOverlapMatch,
    ExtractTagsFromGtf,
    ExtractAlignedFastq,
    DownloadNcbiAssembly,
    CorrectRefalleles,
    BastyGenerateFasta,
    AnnotateVcfWithBed,
    AddGenesAndTranscriptsToGtf,
    ToolTemplate,
    FastqSplitter,
    Squishbed,
    RefflatsStats,
    VcfStats,
    BamStats,
    SamplesTsvToConfig,
    FastqSync,
    RebuildContigmap
  )

//lazy val biopetSummaryTool = project in file("biopet-summary-tool")
lazy val FastqSync = project in file("fastqsync")
lazy val SamplesTsvToConfig = project in file("samplestsvtoconfig")
lazy val VcfStats = project in file("vcfstats")
lazy val BamStats = project in file("bamstats")
lazy val RefflatsStats = project in file("refflatsstats")
lazy val Squishbed = project in file("squishbed")
lazy val ToolTemplate = project in file("tool-template")
lazy val FastqSplitter = project in file("fastq-splitter")
lazy val AddGenesAndTranscriptsToGtf = project in file("addgenesandtranscriptstogtf")
lazy val AnnotateVcfWithBed = project in file("annotatevcfwithbed")
lazy val BastyGenerateFasta = project in file("bastygeneratefasta")
lazy val CorrectRefalleles = project in file("correctrefalleles")
lazy val DownloadNcbiAssembly = project in file("downloadncbiassembly")
lazy val ExtractAlignedFastq = project in file("extractalignedfastq")
lazy val ExtractTagsFromGtf = project in file("extracttagsfromgtf")
lazy val FindOverlapMatch = project in file("findoverlapmatch")
lazy val GtftoRefflat = project in file("gtftorefflat")
lazy val GvcfToBed = project in file("gvcftobed")
lazy val KrakenReportToJson = project in file("krakenreporttojson")
lazy val MpileupToVcf = project in file("mpileuptovcf")
lazy val MultiCoverage = project in file("multicoverage")
lazy val NcbiReporttoContigMap = project in file("ncbireporttocontigmap")
lazy val CountAlleles = project in file("countalleles")
lazy val MergeOtuMaps = project in file("mergeotumaps")
lazy val ReplaceContigsGtffile = project in file("replacecontigsgtffile")
lazy val ReplaceContigsVcffile = project in file("replacecontigsvcffile")
lazy val SnptestToVcf = project in file("snptesttovcf")
lazy val ValidateAnnotation = project in file("validateannotation")
lazy val ValidateFastq = project in file("validatefastq")
lazy val ValidateVcf = project in file("validatevcf")
lazy val VcfFilter = project in file("vcffilter")
lazy val VcfToTsv = project in file("vcftotsv")
lazy val VcfWithVcf = project in file("vcfwithvcf")
lazy val VepNormalizer = project in file("vepnormalizer")
lazy val WipeReads = project in file("wipereads")
lazy val XcnvToBed = project in file("xcnvtobed")
lazy val RebuildContigmap = project in file("rebuildcontigmap")
