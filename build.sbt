organization := "com.github.biopet"
name := "tools"

scalaVersion := "2.11.11"

resolvers += Resolver.sonatypeRepo("snapshots")

fork := true

lazy val tools = (project in file("."))
  .aggregate(
      AddGenesAndTranscriptsToGtf,
      AnnotateVcfWithBed,
      BamStats,
      BaseCounter,
      BastyGenerateFasta,
      CorrectRefalleles,
      CountAlleles,
      DownloadNcbiAssembly,
      DownsampleRegions,
      ExtractAlignedFastq,
      ExtractTagsFromGtf,
      FastqSplitter,
      FastqSync,
      FindOverlapMatch,
      GtftoRefflat,
      GvcfToBed,
      KrakenReportToJson,
      MergeOtuMaps,
      MpileupToVcf,
      MultiCoverage,
      NcbiReporttoContigMap,
      PipelineStatus,
      RebuildContigmap,
      RefflatsStats,
      ReplaceContigsGtffile,
      ReplaceContigsVcffile,
      SamplesTsvToConfig,
      SnptestToVcf,
      SeqStat,
      Squishbed,
      ToolTemplate,
      ValidateAnnotation,
      ValidateFastq,
      ValidateVcf,
      VcfFilter,
      VcfStats,
      VcfToTsv,
      VcfWithVcf,
      VepNormalizer,
      WipeReads,
      XcnvToBed
  )

lazy val AddGenesAndTranscriptsToGtf = project in file("addgenesandtranscriptstogtf")
lazy val AnnotateVcfWithBed = project in file("annotatevcfwithbed")
lazy val BamStats = project in file("bamstats")
lazy val BaseCounter = project in file("basecounter")
lazy val BastyGenerateFasta = project in file("bastygeneratefasta")
lazy val CorrectRefalleles = project in file("correctrefalleles")
lazy val CountAlleles = project in file("countalleles")
lazy val DownloadNcbiAssembly = project in file("downloadncbiassembly")
lazy val DownsampleRegions = project in file("downsampleregions")
lazy val ExtractAlignedFastq = project in file("extractalignedfastq")
lazy val ExtractTagsFromGtf = project in file("extracttagsfromgtf")
lazy val FastqSplitter = project in file("fastq-splitter")
lazy val FastqSync = project in file("fastqsync")
lazy val FindOverlapMatch = project in file("findoverlapmatch")
lazy val GtftoRefflat = project in file("gtftorefflat")
lazy val GvcfToBed = project in file("gvcftobed")
lazy val KrakenReportToJson = project in file("krakenreporttojson")
lazy val MergeOtuMaps = project in file("mergeotumaps")
lazy val MpileupToVcf = project in file("mpileuptovcf")
lazy val MultiCoverage = project in file("multicoverage")
lazy val NcbiReporttoContigMap = project in file("ncbireporttocontigmap")
lazy val PipelineStatus = project in file("pipelinestatus")
lazy val RebuildContigmap = project in file("rebuildcontigmap")
lazy val RefflatsStats = project in file("refflatsstats")
lazy val ReplaceContigsGtffile = project in file("replacecontigsgtffile")
lazy val ReplaceContigsVcffile = project in file("replacecontigsvcffile")
lazy val SamplesTsvToConfig = project in file("samplestsvtoconfig")
lazy val SnptestToVcf = project in file("snptesttovcf")
lazy val SeqStat = project in file("seqstat")
lazy val Squishbed = project in file("squishbed")
lazy val ToolTemplate = project in file("tool-template")
lazy val ValidateAnnotation = project in file("validateannotation")
lazy val ValidateFastq = project in file("validatefastq")
lazy val ValidateVcf = project in file("validatevcf")
lazy val VcfFilter = project in file("vcffilter")
lazy val VcfStats = project in file("vcfstats")
lazy val VcfToTsv = project in file("vcftotsv")
lazy val VcfWithVcf = project in file("vcfwithvcf")
lazy val VepNormalizer = project in file("vepnormalizer")
lazy val WipeReads = project in file("wipereads")
lazy val XcnvToBed = project in file("xcnvtobed")
